package ncb.program;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SplashFx extends Application {
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        ProgressForm pForm = new ProgressForm();

        // do tasks and return result:
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                double i = 0.0;
                updateProgress(i += Database.createAdminDatabase(), 1.0);
                updateProgress(i += Database.createUsersDatabase(), 1.0);
                updateProgress(i += DataSQL.createDataTable(), 1.0);
                updateProgress(i += DataSQL.createLogTable(), 1.0);
                updateProgress(i += DataSQL.createTransTable(), 1.0);
                return null;
            }
        };

        // binds progress of progress bars to progress of task:
        pForm.activateProgressBar(task);

        // get the result of the task and update the UI based on its value:
        task.setOnSucceeded(event -> {
            pForm.getSecondaryStage().close();
        });

        pForm.getSecondaryStage().show();

        Thread thread = new Thread(task);
        thread.start();
    }

    public static class ProgressForm {
        private final Stage secondaryStage = new Stage();
        private final ProgressBar progressBar = new ProgressBar(0);

        public ProgressForm() throws FileNotFoundException {
            // PROGRESS BAR
            progressBar.setProgress(0);

            // image properties
            FileInputStream input = new FileInputStream("C:/Users/Malik Heron/IdeaProjects/NCB Program/src/ncb/icons/logo.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setLayoutX(90);
            imageView.setLayoutY(80);

            // progress bar properties
            progressBar.setPrefSize(403, 25);
            progressBar.setLayoutX(154);
            progressBar.setLayoutY(280);

            // Display objects on screen
            Pane root = new Pane();
            root.getChildren().addAll(imageView, progressBar);

            secondaryStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 710, 422);
            secondaryStage.setScene(scene);
        }

        public void activateProgressBar(final Task<?> task)  {
            progressBar.progressProperty().bind(task.progressProperty());
            secondaryStage.show();
        }

        public Stage getSecondaryStage() {
            return secondaryStage;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}