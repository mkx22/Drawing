# 面向对象实习报告
## 161220091 马可欣

## 引言
本实验的目的在于实现一个画图软件，要求具备基本的画图、组合图形，复制粘贴、添加文字描述及撤销功能。实验中，我采用javaFX技术进行开发，通过其自带的图形类Shape对目标图形进行了构造，并通过画板类在界面上显示。

## 对目标系统的分析和设计
因为实验要求是实现一个画图软件，所以一开始我决定用javaFX中的画布API进行实现，画布API可以通过创建一个Canvas对象，然后获得它的GraphicsContext，渲染自定义的形状，但是如果通过画布实现，每次撤销操作都必须对整块画布进行重绘。所以最后我决定通过javaFX自带的Shape类，构造新的图形类MyShape，将其作为基类，目标图形作为它的派生类，通过类的实例化及相关函数对目标图形进行绘制。

### UML建模
在设计时，我采用了简单工厂模式和组合模式等设计模式，因此在UML建模时也加入了这两种模式。
![a](https://github.com/mkx22/Drawing/blob/master/UML.png)
### 设计模式（详细代码见实现方案）
* 简单工厂模式  
一开始在构造图形时，不同的图形我用不同的派生类进行实例化，但如果使用简单工厂类，我只需要把我需要实例化的图形名作为参数传递给工厂，由工厂进行实现，不仅简化了代码，也使代码的封装性更好。
* 组合模式  
基础功能中要求对组合功能进行实现，因此我使用类组合模式，将组合图形作为组合模式中的容器构件，基础图形作为叶子构件，方便同时操作单个对象和组合对象。
* 建造者模式  
一开始实现文本类时，我直接对文本的字体颜色进行了设置，之后我试着采用设计模式重新对其进行了构造。

## 实现方案
### 算法
画图软件中，是由鼠标的点击拖动来画图的，因此图形的位置和大小是由鼠标点击和松开的位置坐标决定的，因此我用MyShape.java作为基类记录图形的起始坐标及终点坐标，再在派生类中计算大小并返回相应的图形，最后通过画板类实现绘制、复制粘贴、撤回等操作。
### 数据结构
#### 类的介绍
* MyShape.java   
一个抽象类，作为所有图形的基类，记录图形的起始坐标以及终点坐标。
* MyCircle.java、MyEllipse.java、MyLine.java、MyRectangle.java、MyText.java、MyTriangle.java、MyUnion.java  
作为MyShape的派生类，负责基础图形、组合图形及文本框的实现。
* MyFactory.java  
静态工厂类，负责图形的创建。
* DrawBoard.java  
画板类，负责记录单击坐标位置，从而实现图形的绘制、组合、复制粘贴及撤回等操作，同时还负责文件的读写。
* Main.java  
程序的入口。
```javascript
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DrawBoard drawBoard = new DrawBoard();
        final Scene scene = new Scene(drawBoard, 300, 275, Color.WHITE);
        drawBoard.loadBoard(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```
### 设计模式实现
#### 简单工厂模式  
我使用简单工厂模式对图形进行了构造，通过静态方法MyFactory对MyShape类及其子类对象进行实例化。客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可。同时简化了代码实现，增强了代码的灵活度。

* 静态工厂方法
```javascript
public class MyFactory {
    public static MyShape createShape(String name, double x1, double y1, double x2, double y2) {
        MyShape myShape = null;
        switch (name) {
            case "circle":
            case "circle2":
                myShape = new MyCircle(x1, y1, x2, y2);
                break;
            case "ellipse":
            case "ellipse2":
                myShape = new MyEllipse(x1, y1, x2, y2);
                break;
            //...
        }
        return myShape;
    }
}
```

* 客户端代码
```javascript
public class DrawBoard extends Group {
    public void draw(String string, double x1, double y1, double x2, double y2, boolean flag) {
        MyShape shape = MyFactory.createShape(string, x1, y1, x2, y2);//    通过工厂类创建产品对象
        //...
    }
}
```
#### 组合模式  
根据基础功能要求，除了实现圆形、三角形等基础图形，还需要对其进行组合，因此我采用了组合模式，将圆形、三角形等基础图形作为组合模式中的叶子对象，将组合图形作为容器对象，使客户端可以统一对待单个对象和组合对象。

* 抽象构件：MyShape.java
```javascript
public abstract class MyShape {
    public abstract void removeTmpshapes(MyShape myShape);
    public abstract void addTmpshapes(MyShape myShape);
    public abstract MyShape getChild(int i);
}
```
* 叶子构件：MyLine.java
```javascript
public class MyLine extends MyShape {
    public void removeTmpshapes(MyShape myShape) {
        //异常处理或错误提示
    }

    public void addTmpshapes(MyShape myShape) {
        //异常处理或错误提示
    }

    public MyShape getChild(int i) {
        //异常处理或错误提示
        return null;
    }

}
```
* 容器构件：MyUnion.java
```javascript
public class MyUnion extends MyShape {
    ArrayList<MyShape> tmpshapes = new ArrayList<>();
    public void removeTmpshapes(MyShape myShape){
        tmpshapes.remove(myShape);
    }
    public void addTmpshapes(MyShape myShape){
        tmpshapes.add(myShape);
    }
    public MyShape getChild(int i){
        return (MyShape)tmpshapes.get(i);
    }
}
```
#### 建造者模式  
* 具体建造者类：TextBuilder.java
```javascript
public class TextBuilder {
    MyText myText;

    public TextBuilder() {
        myText = new MyText();
    }

    public void buildFont() {
        myText.setFont(Font.font(1));
    }

    public void buildText() {
        myText.setString("一段话");
    }

    public void buildColor() {
        myText.setColor(Color.RED);
    }

    public MyText builderText() {
        buildColor();
        buildFont();
        buildText();
        return myText;
    }
}
```
* 客户类代码片段：
```javascript
    //文字描述
    public void addText(ToolBar toolBar) {
        TextField text = new TextField();
        TextBuilder builder=new TextBuilder();
        MyText myText=builder.builderText();
        text.setText(myText.getString());
        //text.clear();
        toolBar.getItems().add(new Label("文字描述："));
        toolBar.getItems().add(text);
    }
```

## 实现功能介绍

### 基础功能：
* 可绘制三角形、方框、圆形、椭圆、连接线等图形
* 允许用户添加文字描述
* 单击可以选中图形，允许对图形的拷贝复制
* 多个图形可以组合，组合后的图形同样有拷贝复制的功能
* 支持撤销上一步操作的功能

### 扩展功能：
* 支持撤销多步的功能
* 支持将图形以文件形式存储并加载，文件名以保存日期命名
* 支持对线条粗细进行调整
* 支持清空画布，创建新的画布

## 界面展示
* 运行源代码，出现一个小的窗口，此时需要放大至全屏，否则绘制图形位置不准确。
![a](https://github.com/mkx22/Drawing/blob/master/report/1.png)
* 放大至全屏后，可以看到菜单栏，点击菜单栏上的File，可以看到相关操作选项（Edit和View是为了美观加上去的，点了也没用...）  
![a](https://github.com/mkx22/Drawing/blob/master/report/2.png)
  * 点击New：清空当前画板（原画布不会自动保存），创建一个新的画板
  * 点击Save：保存当前画板上的图形
  * 点击Load：会出现一个文件选择框，点击想要加载的图片文件进行加载即可，加载出来的图形有可能会被菜单栏和工具栏挡住= =
  * 点击Exit：退出软件
* 菜单栏下面是工具栏，从左到右依次是撤销、绘制图形（空心/实心）、组合、复制、粘贴、选择绘制线条粗细和文字描述  
![a](https://github.com/mkx22/Drawing/blob/master/report/3.png)
  * 点击撤销：![a](https://github.com/mkx22/Drawing/blob/master/report/7.png) 支持多次撤销，组合图形后再点击撤销，图形不会消失，而是会回到组合前的样子（和组合前没什么区别），再次点击撤销图形依次消失。
  * 点击图形：再点击画板，拖动一下就能画出图形。
  * 点击组合：![a](https://github.com/mkx22/Drawing/blob/master/report/8.png) 想象你在画一个方框，用这个方框把你想要组合的图形框起来就行啦，之后就可以对组合图形进行复制粘贴。
  * 点击复制粘贴：![a](https://github.com/mkx22/Drawing/blob/master/report/4.png)
    * 复制：先点击复制，再点击你想要复制的图形，空心图形需要点击线条，实心图形可以直接点击图形，如果选择成功，菜单栏右边会出现“选择成功”的字样，否则会出现“选择失败”。
    * 粘贴：复制成功后点击粘贴，即可对想要复制的图形进行粘贴，支持多次粘贴。
  * 点击文字描述：初始输入框上显示的是“一句话”，直接点击改动即可。  
  ![a](https://github.com/mkx22/Drawing/blob/master/report/6.png)









