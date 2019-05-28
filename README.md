# Drawing

## 引言
本实验的目的在于实现一个画图软件，要求具备基本的画图、组合图形，复制粘贴、添加文字描述及撤销功能。实验中，我采用javaFX技术进行开发，通过其自带的图形类Shape对目标图形进行了构造，并通过画板类在界面上显示。

## 对目标系统的分析和设计
因为实验要求是实现一个画图软件，所以一开始我决定用javaFX中的画布API进行实现，画布API可以通过创建一个Canvas对象，然后获得它的GraphicsContext，渲染自定义的形状，但是如果通过画布实现，每次撤销操作都必须对整块画布进行重绘，过于繁琐。所以最后我决定通过javaFX自带的Shape类，构造新的图形类MyShape，将其作为基类，目标图形作为它的派生类，通过类的实例化及相关函数对目标图形进行绘制。

### UML建模

### 设计模式
* 简单工厂模式
我使用简单工厂模式对图形进行了构造，通过静态方法MyFactory对MyShape类及其子类对象进行实例化。客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可。同时简化了代码实现，增强了代码的灵活度。
* 组合模式
根据基础功能要求，除了实现圆形、三角形等基础图形，还需要对其进行组合，因此我采用了组合模式，将圆形、三角形等基础图形作为组合模式中的叶子对象，将组合图形作为容器对象，使客户端可以统一对待单个对象和组合对象
* 模式

## 实现方案

### 算法

### 数据结构

### 设计模式实现
#### 简单工厂模式  
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
#### 模式  

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

### TODO：
* 右键点击图形可通过文本框对图形尺寸进行调整
* 支持个性化界面
* 支持图形（包括组合图形）的拖拽调整图形大小

## 界面展示
