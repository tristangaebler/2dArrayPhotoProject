package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
	  Picture android = new Picture("Android.png");
	  android.explore();
	  android.keepOnlyBlue();
	  android.explore();
  }
  
  public static void testKeepOnlyRed()
  {
	  Picture android = new Picture("Android.png");
	  android.explore();
	  android.keepOnlyRed();
	  android.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
	  Picture android = new Picture("Android.png");
	  android.explore();
	  android.keepOnlyGreen();
	  android.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	Picture caterpillar = new Picture("caterpillar.jpg");
	caterpillar.explore();
	caterpillar.mirrorVerticalRightToLeft();
	caterpillar.explore();
  }
  
  public static void testRandomColor()
  {
	  Picture randomDroid = new Picture("Android.png");
	  randomDroid.explore();
	  randomDroid.randomColor();
	  randomDroid.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
	  Picture moon = new Picture("moon-surface.jpg");
	  moon.createCollage();
	  moon.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2() 
  {
	  Picture edge = new Picture("beach.jpg");
	  edge.edgeDetection2(15);
	  edge.explore();
  }
  
  public void testMirrorDiagnol()
  {
	  Picture diagnolImage = new Picture("redMotorcycle.jpg");
	  diagnolImage.mirrorDiagonal();
	  diagnolImage.explore();
  }
  
  public void testNegate()
  {
	  Picture negate = new Picture("swan.jpg");
	  negate.negate();
	  negate.explore();
  }
  
  public void testGrayScale()
  {
	  Picture grey = new Picture("beach.jpg");
	  grey.grayScale();
	  grey.explore();
  }
  
  public void testFixUnderwater()
  {
	  Picture underwater = new Picture("water.jpg");
	  underwater.fixUnderwater();
	  underwater.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
	//testRandomColor();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
	  testMyCollage();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}