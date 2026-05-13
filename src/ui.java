import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ui extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane border=new BorderPane();

//هنا عملت مسافه بين الازرار 10 وعملت مسافه بين الازرار والscene مسافه 10
VBox sidebar=new VBox();
sidebar.setSpacing(10);
sidebar.setPadding(new Insets(10));

//هنا عملت اربع ازرار ف ال sidebar ووحدت العرض ف كله
        Button dashboardBtn = new Button("Dashboard");
        Button accountsBtn = new Button("Accounts");
        Button loansBtn = new Button("Loans");
        Button transferBtn = new Button("Transfer");
        dashboardBtn.setPrefWidth(150);
        accountsBtn.setPrefWidth(150);
        loansBtn.setPrefWidth(150);
        transferBtn.setPrefWidth(150);

//هنا ضيفت الازرار للsidebar
        sidebar.getChildren().addAll(dashboardBtn, accountsBtn, loansBtn, transferBtn);

        //هنا حطيت ال sidebar ع الشمال
        border.setLeft(sidebar);
 // 2
// دا حزء ال Tableview

        //هنا عملت الجدول
        TableView tableView = new TableView();

        //البيانات اللي هتظهر فوق
        TableColumn colAccountNumber = new TableColumn("Account Number");
        TableColumn colAccountType = new TableColumn("Type");
        TableColumn colBalance = new TableColumn("Balance ($)");

        //دا هنا عملت عرض الاعمده لكل واحد
        colAccountNumber.setPrefWidth(200);
        colAccountType.setPrefWidth(150);
        colBalance.setPrefWidth(150);

        //عملت اضافه الاعمده للجدول
        tableView.getColumns().addAll(colAccountNumber, colAccountType, colBalance);

        //هنا حطيته ف المنتصف
        BorderPane.setMargin(tableView, new Insets(10));
        border.setCenter(tableView);

     // 3

        // هنا بيعرض الحسابات ع الافقي
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("الحسابات");

// هنا بيعرض الرصيد ع الراسي
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("الرصيد ($)");

        // إنشاء الشارت وربطه بالمحاور
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

// إعدادات الشكل
        barChart.setTitle("مقارنة أرصدة الحسابات");
        barChart.setPrefHeight(250);
        barChart.setAnimated(true);

        //  عملنا VBox  عشان نحط الجدول والشارت فوق بعض
        VBox centerContent = new VBox(20); // مسافة 20 بين الجدول والشارت
        centerContent.setPadding(new Insets(10));

//  إضافة الجدول  والشارت  للحاوية
        centerContent.getChildren().addAll(tableView, barChart);

//  وضع الحاوية كلها في نص الـ BorderPane
        border.setCenter(centerContent);




        Scene scene = new Scene(border, 700, 400);
        stage.setTitle("Bank System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}