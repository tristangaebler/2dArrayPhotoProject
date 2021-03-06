package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	int tempBlue = pixelObj.getBlue();
        pixelObj.setBlue(0);
        tempBlue = pixelObj.getBlue();
      }
    }
  }
  
  /*Method to set the red to 0 */
  public void zeroRed() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray) 
		  {
			  pixelObj.setBlue(0);
		  }
	  }
  }
  
  /*Method to set the green to 0 */
  public void zeroGreen() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixel : rowArray)
		  {
			  pixel.setGreen(0);
			  pixel.setRed(0);
			  
		  }
	  }
  }
  
  public void keepOnlyRed() 
  {
	 zeroGreen();
	 zeroBlue();
  }
  
  public void keepOnlyGreen()
  {
	  zeroRed();
	  zeroBlue();
  }
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int height = pixels.length;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < height / 2; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[height - 1 - row][col];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  public void randomColor()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int randomRed, randomGreen, randomBlue;
			  randomRed = (int)(Math.random() * 256);
			  randomBlue = (int)(Math.random() * 256);
			  randomGreen = (int)(Math.random() * 256);
			  
			  currentPixel.setGreen(randomGreen);
			  currentPixel.setBlue(randomBlue);
			  currentPixel.setRed(randomRed);
		  }
	  }
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = pixels[0].length - 1; col > width / 2; col--)
		  {
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][(width / 2) - (col - width / 2)];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontalBottomToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int height = pixels.length;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < height / 2; col++)
		  {
			  leftPixel = pixels[height - 1 -row][col];
			  rightPixel = pixels[row][col];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
	  
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel TopPixel = null;
	  Pixel BottomPixel = null;
	  int point1 = 220;
	  int point2 = 275;
	  for(int row = 160; row < point1; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  TopPixel = pixels[row][col];
			  BottomPixel = pixels[point1 - row + point1][col];
			  BottomPixel.setColor(TopPixel.getColor());
		  }
	  }
	  
	  for(int row = 255; row < point2; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  TopPixel = pixels[row][col];
			  BottomPixel = pixels[point2 - row + point2][col];
			  BottomPixel.setColor(TopPixel.getColor());
		  }
	  }
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 400;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int count = 0;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  //Looping through the rows
	  for(int row = 220; row < 330; row++)
	  {
		  //Loop to the mirror point
		  for(int col = 248; col < 348; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        bottomPixel = pixels[row+1][col];
        rightColor = rightPixel.getColor();
        bottomColor = bottomPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(bottomColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel rightPixel = null;
	  Pixel leftPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  for(int row = 0; row < height; row++)
	  {
		  for(int col = 0; col < width; col++)
		  {
			  if(col < height && row < width)
			  {
				  rightPixel = pixels[row][col];
				  leftPixel = pixels[col][row];
				  leftPixel.setColor(rightPixel.getColor());
			  }
		  }
	  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  int green = pixelObj.getGreen();
	    	  int red = pixelObj.getRed();
	    	  int blue = pixelObj.getBlue();
	    	  
	    	  int negateGreen = 255 - green;
	    	  int negateRed = 255 - red;
	    	  int negateBlue = 255 - blue;
	    	  
	    	  Color negateColor = new Color(negateRed, negateGreen, negateBlue);
	    	  pixelObj.setColor(negateColor);
	      }
	    }
  }

  public void grayScale()
  {
	  Pixel[][] Pixel = this.getPixels2D();
	    for (Pixel[] rowArray : Pixel)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  int redColor = pixelObj.getRed();
	    	  int blueColor = pixelObj.getBlue();
	    	  int greenColor = pixelObj.getGreen();
	    	  int average = (redColor + blueColor + greenColor) / 3;
	    	  Color grayColor = new Color(average, average, average);
	    	  pixelObj.setColor(grayColor);
	      }
	  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] Pixels = this.getPixels2D();
	  for (Pixel[] rowArray : Pixels)
	  {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  if(pixelObj.getRed() > 20 || pixelObj.getBlue() < 160)
	    	  {
	    		  pixelObj.setBlue(0);
	    		  pixelObj.setRed(0);
	    		  pixelObj.setGreen(0);
	    	  }

	      }
	  }
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /**Method creates my own custom collage */
  public void myCollage()
  {
	  Picture moon = new Picture("moon-surface.jpg");
	  Picture moon2 = new Picture("moon-surface.jpg");
	  this.copy(moon, 0, 0);
	  this.copy(moon2, 175, 0);
	  this.copy(moon, 275, 0);
	  Picture moonMirror = new Picture(moon);
	  moon.mirrorHorizontal();
	  this.copy(moonMirror, 200, 0);
	  this.copy(moon, 400, 0);
	  this.copy(moon2, 500, 0);
	  this.mirrorVertical();
	  this.write("myCollage.jpg");
  }
  

  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture android = new Picture("seagull.jpg");
    android.explore();
    //android.createCollage();
    //android.keepOnlyGreen();
    //android.mirrorVerticalRightToLeft();
   // android.mirrorHorizontal();
    //android.mirrorTemple();
    //android.mirrorHorizontal();
    //android.mirrorHorizontalBottomToTop();
    //android.mirrorArms();
    //android.mirrorVertical();
    //android.zeroBlue();
    //android.mirrorGull();
    //android.secondCopy(277, 50, 200, 300, 30);
    android.explore();
    //android.write("Android.png");
  }
  
} // this } is the end of class Picture, put all new methods before this
