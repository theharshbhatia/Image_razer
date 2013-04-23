import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ImageRazer extends JFrame {
    DisplayPanel displayPanel;

    JButton brightenButton, darkenButton, contrastIncButton, contrastDecButton,
            reverseButton, resetButton,Edgedraw,Blur,GrayScale,Thinning,Binary,
            Only_RED,Only_YELLOW,Only_BLUE,Only_GREEN,Only_MAGENTA,Only_CYAN,
            Noise,Pixelate,Burn,Gaussian,Flip_Diagonal,Flip_Vertical,Flip_Horizontal,
            HistogramThreshold,Posterise;

    public ImageRazer() {
        super("Image Razer ");
        Container container = getContentPane();

        displayPanel = new DisplayPanel();
        container.add(displayPanel);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(13, 2));
        panel.setBorder(new TitledBorder("Choose the option"));
        Posterise = new JButton("Posterise");
        Posterise.addActionListener(new ImageRazer.ButtonListener());
                
        HistogramThreshold = new JButton("Histogram Threshold");
        HistogramThreshold.addActionListener(new ImageRazer.ButtonListener());
        
        Flip_Horizontal = new JButton("Flip Horizontal");
        Flip_Horizontal.addActionListener(new ImageRazer.ButtonListener());
        
        Flip_Vertical = new JButton("Flip Vertical");
        Flip_Vertical.addActionListener(new ImageRazer.ButtonListener());
        
        Flip_Diagonal = new JButton("Flip Diagonal");
        Flip_Diagonal.addActionListener(new ImageRazer.ButtonListener());
        
        Gaussian = new JButton("Gaussian");
        Gaussian.addActionListener(new ImageRazer.ButtonListener());
        
        
        Burn = new JButton("Burn");
        Burn.addActionListener(new ImageRazer.ButtonListener());
        
        Pixelate = new JButton("Pixelate");
        Pixelate.addActionListener(new ImageRazer.ButtonListener());
        
        Noise = new JButton("Noise");
        Noise.addActionListener(new ImageRazer.ButtonListener());
        
        Only_YELLOW = new JButton("Only YELLOW");
        Only_YELLOW.addActionListener(new ImageRazer.ButtonListener());
        
        Only_MAGENTA = new JButton("Only MAGENTA");
        Only_MAGENTA.addActionListener(new ImageRazer.ButtonListener());
        
        Only_GREEN = new JButton("Only GREEN");
        Only_GREEN.addActionListener(new ImageRazer.ButtonListener());
        
        Only_CYAN = new JButton("Only CYAN");
        Only_CYAN.addActionListener(new ImageRazer.ButtonListener());
        
        Only_BLUE = new JButton("Only BLUE");
        Only_BLUE.addActionListener(new ImageRazer.ButtonListener());
        
        Only_RED = new JButton("Only RED");
        Only_RED.addActionListener(new ImageRazer.ButtonListener());
        
        Binary = new JButton("Binary");
        Binary.addActionListener(new ImageRazer.ButtonListener());
        
        Thinning = new JButton("Thinning");
        Thinning.addActionListener(new ImageRazer.ButtonListener());
        
        GrayScale = new JButton("GrayScale");
        GrayScale.addActionListener(new ImageRazer.ButtonListener());
        
        Blur = new JButton("Blur");
        Blur.addActionListener(new ImageRazer.ButtonListener());
        
        Edgedraw = new JButton("Edgedraw");
        Edgedraw.addActionListener(new ImageRazer.ButtonListener());
        
        brightenButton = new JButton("Brightness >>");
        brightenButton.addActionListener(new ImageRazer.ButtonListener());
        
        darkenButton = new JButton("Darkness >>");
        darkenButton.addActionListener(new ImageRazer.ButtonListener());
        
        contrastIncButton = new JButton("Contrast >>");
        contrastIncButton.addActionListener(new ImageRazer.ButtonListener());
        
        contrastDecButton = new JButton("Contrast <<");
        contrastDecButton.addActionListener(new ImageRazer.ButtonListener());
        
        reverseButton = new JButton("Negative");
        reverseButton.addActionListener(new ImageRazer.ButtonListener());
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ImageRazer.ButtonListener());

        panel.add(brightenButton);
        panel.add(darkenButton);
        panel.add(contrastIncButton);
        panel.add(contrastDecButton);
        panel.add(reverseButton);
        panel.add(Flip_Diagonal);
        panel.add(Flip_Vertical);
       panel.add(Flip_Horizontal);
        
        panel.add(resetButton);
        panel.add(Edgedraw);
        panel.add(Blur);
        panel.add(GrayScale);
        panel.add(Binary);
        panel.add(Thinning);
        panel.add(Noise);
        panel.add(Pixelate);
        panel.add(Burn);
        panel.add(Posterise);
        panel.add(HistogramThreshold);
        panel.add(Gaussian);
        panel.add(Only_RED);
        panel.add(Only_GREEN);
        panel.add(Only_BLUE);
        panel.add(Only_YELLOW);
        panel.add(Only_CYAN);
        panel.add(Only_MAGENTA);
        
        container.add(BorderLayout.EAST, panel);

        addWindowListener(new ImageRazer.WindowEventHandler());
        setSize(displayPanel.getWidth(), displayPanel.getHeight() + 25);
        show();
    }

    class WindowEventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String arg[]) {
        new ImageRazer();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            if (button.equals(brightenButton)) {
                displayPanel.brightenLUT();
                displayPanel.applyFilter();
                displayPanel.repaint();
            } else if (button.equals(darkenButton)) {
                displayPanel.darkenLUT();
                displayPanel.applyFilter();
                displayPanel.repaint();
            } else if (button.equals(contrastIncButton)) {
                displayPanel.contrastIncLUT();
                displayPanel.applyFilter();
                displayPanel.repaint();
            } else if (button.equals(contrastDecButton)) {
                displayPanel.contrastDecLUT();
                displayPanel.applyFilter();
                displayPanel.repaint();
            } else if (button.equals(Edgedraw)) {
                displayPanel.Edgedraw();
                displayPanel.repaint();
            }else if (button.equals(Blur)) {
                displayPanel.Blur();
                displayPanel.repaint();} 
            else if (button.equals(GrayScale)) {
                displayPanel.GrayScale();
                displayPanel.repaint();} 
            else if (button.equals(Binary)) {
                displayPanel.Binary();
                displayPanel.repaint();} 
            else if (button.equals(Thinning)) {
                displayPanel.Thinning();
                displayPanel.repaint();} 
            else if (button.equals(Burn)) {
                displayPanel.Burn();
                displayPanel.repaint();} 
            else if (button.equals(Gaussian)) {
                displayPanel.Gaussian();
                displayPanel.repaint();} 
            else if (button.equals(HistogramThreshold)) {
                displayPanel.HistogramThreshold();
                displayPanel.repaint();} 
            
            else if (button.equals(Posterise)) {
                displayPanel.Posterise();
                displayPanel.repaint();} 
            
            else if (button.equals(Flip_Diagonal)) {
                displayPanel.Flip_Diagonal();
                displayPanel.repaint();}
            else if (button.equals(Flip_Vertical)) {
                displayPanel.Flip_Vertical();
                displayPanel.repaint();}
            else if (button.equals(Flip_Horizontal)) {
                displayPanel.Flip_Horizontal();
                displayPanel.repaint();}
            
            else if (button.equals(Only_RED)) {
                displayPanel.Only_RED();
                displayPanel.repaint();} 
            else if (button.equals(Only_BLUE)) {
                displayPanel.Only_BLUE();
                displayPanel.repaint();}
            else if (button.equals(Only_GREEN)) {
                displayPanel.Only_GREEN();
                displayPanel.repaint();}
            else if (button.equals(Only_CYAN)) {
                displayPanel.Only_CYAN();
                displayPanel.repaint();}
            else if (button.equals(Noise)) {
                displayPanel.Noise();
                displayPanel.repaint();}
            else if (button.equals(Pixelate)) {
                displayPanel.Pixelate();
                displayPanel.repaint();}
            else if (button.equals(Only_MAGENTA)) {
                displayPanel.Only_MAGENTA();
                displayPanel.repaint();}
            else if (button.equals(Only_YELLOW)) {
                displayPanel.Only_YELLOW();
                displayPanel.repaint();}
            else if (button.equals(reverseButton)) {
                displayPanel.reverseLUT();
                displayPanel.applyFilter();
                displayPanel.repaint();
            } else if (button.equals(resetButton)) {
                displayPanel.reset();
                displayPanel.repaint();
            }
        }
    }
}

class DisplayPanel extends JPanel {
    Image displayImage;
    BufferedImage bi;
    Graphics2D big;
    LookupTable lookupTable;

    DisplayPanel() {
        setBackground(Color.black); 
        loadImage();
        setSize(displayImage.getWidth(this), displayImage.getWidth(this));
        createBufferedImage();
    }

    public void loadImage() {
        displayImage = Toolkit.getDefaultToolkit().getImage("y.jpg");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(displayImage, 1);
        try {
            mt.waitForAll();
        } catch (Exception e) {
            System.out.println("Exception while loading.");
        }

        if (displayImage.getWidth(this) == -1) {
            System.out.println("No jpg file");
            System.exit(0);
        }
    }

    public void createBufferedImage() {
        bi = new BufferedImage(displayImage.getWidth(this), displayImage.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        big = bi.createGraphics();
        big.drawImage(displayImage, 0, 0, this);
            }

    public void brightenLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i + 10);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    public void darkenLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i - 10);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    public void contrastIncLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i * 1.2);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    public void contrastDecLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i / 1.2);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    public void reverseLUT() {
        byte reverse[] = new byte[256];
        for (int i = 0; i < 256; i++) {
            reverse[i] = (byte) (255 - i);
        }
        lookupTable = new ByteLookupTable(0, reverse);
    }

    public void reset() {
        big.setColor(Color.black);
        big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
        big.drawImage(displayImage, 0, 0, this);
    }

    
    public void applyFilter() {
        LookupOp lop = new LookupOp(lookupTable, null);
        lop.filter(bi, bi);
    }

    public void update(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        paintComponent(g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bi, 0, 0, this);
    }
    
    
    
    public void Only_BLUE() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getBlue();
																		
						rgb = (0xff000000) | (0 << 16) | (0 << 8) | (r << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
  			
  	public void Only_GREEN() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getGreen();
																		
						rgb = (0xff000000) | (0 << 16) | (r << 8) | (0 << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
  			
  	public void Only_MAGENTA() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getGreen();
																		
						rgb = (0xff000000) | (255 << 16) | (r << 8) | (255 << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
  			
  	public void Only_YELLOW() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getGreen();
																		
						rgb = (0xff000000) | (255 << 16) | (255 << 8) | (r << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
  			
  	public void Only_CYAN() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getGreen();
																		
						rgb = (0xff000000) | (r << 16) | (255 << 8) | (255 << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
    public void Only_RED() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getRed();
																		
						rgb = (0xff000000) | (r << 16) | (0 << 8) | (0 << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
    
    
    
    public void Binary() 
  			{

    			int w =  bi.getWidth();
    			int h =  bi.getHeight();
    			int array[] = new int[256];
    			int rgb;
    			
    			GrayScale();


        		for(int y = 0; y < h-1; y++)
					{
						for(int x = 0; x < w-1; x++)
							{
								rgb = bi.getRGB(x,y);
								Color c= new Color(rgb);
								int intensity = c.getRed();
								array[intensity]++;
																			
							}
					}
					
				int max = array[0];
				int pos = 0;
				for(int z = 0; z < 255; z++)
					{
						if(array[z] > max)
							{
								max=array[z];
								pos=z;
							}
					}
				array[pos]=0;
					
				int max2 = array[0];
				int pos2=0;
   				for(int z = 0; z < 255; z++)
					{
						if(array[z] > max2)
							{
								max2=array[z];
								pos2=z;
							}
					}
    			int thres = (pos+pos2)/2;
   	 			
   	 			for(int y = 0; y < h; y++)
					{
						for(int x = 0; x < w; x++)
							{
								rgb = bi.getRGB(x,y);
								Color c22 = new Color(rgb);
								int intensity = c22.getRed();
								
								if(intensity < 100)
									{
										rgb = (0xff000000) | (0 << 16) | (0 << 8) | (0<< 0);
           							    bi.setRGB(x, y, rgb);
									}	
         					   else
          						  	{
              							rgb = (0xff000000) | (255 << 16) | (255 << 8) | (255<< 0);
               							bi.setRGB(x, y, rgb);
            						}
							}
					}
			}
    
    
    
    
    public void Thinning()
			{
				
				float data[] = { 1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f };
    			Kernel kernel = new Kernel(3, 3, data);
   		 		int w =  bi.getWidth();
    			int h =  bi.getHeight();
   		 		Binary();
   		 		BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
   		 		ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
    			convolve.filter(bi,output);
    			
    			
    			for(int y=0;y<h;y++)
                	{
                		for(int x=0;x<w;x++)
                		{
                			int rgby = bi.getRGB(x, y);
                			Color cy = new Color(rgby);
                			int ry=cy.getRed();
                			if(ry==0)
                				ry=255;
                			else
                				ry=0;
                			int rgbx=output.getRGB(x,y);
                			Color cx =new Color(rgbx);
                			int rx=cx.getRed();             		
                			if(rx==255 && ry==255)
                				{
                					rgbx = (0xff000000) | (0 << 16) | (0 << 8) | (0 << 0);               				
                					output.setRGB(x, y, rgbx);
                				}
                			else
                				{
                					rgbx = (0xff000000) | (255 << 16) | (255 << 8) | (255 << 0);               				
                					output.setRGB(x, y, rgbx);
                				}               	                      			            		
                		}
                	} 
                bi=output;                        
			}
    public void GrayScale() 
    		{
    			for(int y=0;y<bi.getHeight();y++)
    			{
    				for(int x=0;x<bi.getWidth();x++)
    				{
    					int rgb = bi.getRGB(x, y);
						Color c = new Color(rgb);
						
						int r=c.getRed();
						int b=c.getBlue();
						int g=c.getGreen();
						
						int avg=(r+g+b)/3;
												
						rgb = (0xff000000) | (avg << 16) | (avg << 8) | (avg << 0);
  
                		bi.setRGB(x, y, rgb);
    				}
    			}	
    			
  			}
    public void Burn() {
		int w =  bi.getWidth();
    int h =  bi.getHeight();
       
 BufferedImage dest = new BufferedImage(w, h, bi.getType());
 
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
 
				int burn = px << 8; //this was a lucky guess. not sure why it works
 
				dest.setRGB(x, y, burn);
			}
		}
 
		bi= dest;
	}
   public void Pixelate() {
	int size=10;	
        int w =  bi.getWidth();
    int h =  bi.getHeight();
       
 BufferedImage dest = new BufferedImage(w, h, bi.getType());
		for (int x = 0; x < bi.getWidth(); x+=size) {
			for (int y = 0; y < bi.getHeight(); y+=size) {
 
				int px = 0;
 
				for (int xi = 0; xi < size; xi++) {
					for (int yi = 0; yi < size; yi++) {
						px += bi.getRGB(x, y);
						px = px / 2;
					}
				}
 
				for (int xi = 0; xi < size; xi++) {
					for (int yi = 0; yi < size; yi++) {
						dest.setRGB(x+xi, y+yi, px);
					}
				}
			}
		}
 
		bi=dest;
	}
   
   public void Gaussian() {
		int cuttoff = 2000;
		double magic = 1.442695;
		int xcenter = bi.getWidth() / 2 - 1;
		int ycenter = bi.getHeight() / 2 - 1;
 int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
		
 
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
 
				double distance = Math.sqrt(x*x+y*y);
				double value = px*255*Math.exp((-1*distance*distance)/(magic*cuttoff*cuttoff));
				dest.setRGB(x, y, (int) value);	
 
			}
		}
 
		bi = dest;
 
	}
   
    public void Noise() {
    
 int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
		
		int quantity = 10;
		 int threshold = 50;
 
		Random r = new Random();
 
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
 
				int ran = r.nextInt(quantity);
				if (ran <= 1) {
 
					int amount = r.nextInt(threshold);
					int red = ((px >> 16) & 0xFF) + amount;
 
					amount = r.nextInt(threshold);
					int green = ((px >> 8) & 0xFF) + amount;	
 
					amount = r.nextInt(threshold);			
					int blue = (px & 0xFF) + amount;
 
					//Overflow fix
					if (red > 255) { red = 255; }
					if (green > 255) { green = 255; }
					if (blue > 255) { blue = 255; }
 
					px = (0xFF<<24) + (red<<16) + (green<<8) + blue;
				}
 
				dest.setRGB(x, y, px);
			}
		}
 
		bi= dest;
	}
    
    public void Flip_Diagonal() {
		int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
    
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
				int destX = bi.getWidth() - x - 1;
				int destY = bi.getHeight() - y - 1;
				dest.setRGB(destX, destY, px);			
			}
		}
 
		bi= dest;
	}
 
    public void Flip_Vertical() {
		int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
        for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
				dest.setRGB(x, bi.getHeight() - y - 1, px);			
			}
		}
 
	bi= dest;
	}
 public void Flip_Horizontal() {
     int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
		
     for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
				dest.setRGB(bi.getWidth() - x - 1, y, px);			
			}
		}
 
		bi= dest;
	}
 
 
    public void HistogramThreshold() {
        
 int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
		int threshold=50;
		int reds[] = new int[256];
		int greens[] = new int[256];
		int blues[] = new int[256];
 
 
		
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
 
 
				int red = ((px >> 16) & 0xFF);
				reds[red]++;
 
				int green = ((px >> 8) & 0xFF);
				greens[green]++;
 
				int blue = (px & 0xFF);
				blues[blue]++;
 
				dest.setRGB(x, y, px);
			}
		}
 
		
		int mostCommonRed = 0;
		int mostCommonBlue = 0;
		int mostCommonGreen = 0;
 
		for (int i = 0; i < 256; i++) {
			if (reds[i] > mostCommonRed) {
				mostCommonRed = i;
			}
 
			if (blues[i] > mostCommonBlue) {
				mostCommonBlue = i;
			}
 
			if (greens[i] > mostCommonGreen) {
				mostCommonGreen = i;
			}
		}
 
		
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				int px = bi.getRGB(x, y);
 
				int red = ((px >> 16) & 0xFF);
				int green = ((px >> 8) & 0xFF);				
				int blue = (px & 0xFF);
				int val = 0;
 
 
				if (((red - 20 < mostCommonRed) && (red + threshold > mostCommonRed)) || ((blue - threshold < mostCommonBlue) && (blue + threshold > mostCommonBlue)) || ((green - threshold < mostCommonGreen) && (green + threshold > mostCommonGreen))) {
					val = (0xFF<<24) + (red<<16) + (green<<8) + blue;
				} else {
					val = (0xFF<<24) + (0xFF<<16) + (0xFF<<8) + 0xFF;
				}
 
 
				dest.setRGB(x, y, val);
			}
		}
 
		bi= dest;
	}
    
    
    public void Blur() {

    int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage output = new BufferedImage(w, h, bi.getType());

	for (int y = 1; y < h - 1; y++) 
		{
            for (int x = 1; x < w - 1; x++) 
            {
				int rgb = bi.getRGB(x-1, y-1);
				Color c00 = new Color(rgb);
                rgb = bi.getRGB(x-1, y);
                Color c01 = new Color(rgb);
                rgb = bi.getRGB(x-1, y+1);
                Color c02 = new Color(rgb);
                rgb = bi.getRGB(x, y-1);
                Color c10 = new Color(rgb);
                rgb = bi.getRGB(x, y);
                Color c11 = new Color(rgb);
                rgb = bi.getRGB(x, y+1);
                Color c12 = new Color(rgb);
                rgb = bi.getRGB(x+1, y-1);
                Color c20 = new Color(rgb);
                rgb = bi.getRGB(x+1, y);
                Color c21 = new Color(rgb);
                rgb = bi.getRGB(x+1, y+1);
                Color c22 = new Color(rgb);
                
                int r = c00.getRed() + c01.getRed() + c02.getRed() +
                        c10.getRed() + c11.getRed() + c12.getRed() +
                        c20.getRed() + c21.getRed() + c22.getRed();
                int g = c00.getGreen() + c01.getGreen() + c02.getGreen() +
                        c10.getGreen() + c11.getGreen() + c12.getGreen() +
                        c20.getGreen() + c21.getGreen() + c22.getGreen();
                int b = c00.getBlue() + c01.getBlue() + c02.getBlue() +
                        c10.getBlue() + c11.getBlue() + c12.getBlue() +
                        c20.getBlue() + c21.getBlue() + c22.getBlue();
                
                r=r/9;
                g=g/9;
                b=b/9;
                
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                Color c = new Color(r, g, b);
                rgb = (0xff000000) | (r << 16) | (g << 8) | (b << 0);
  
                output.setRGB(x, y, rgb);
            }
        }

    bi=output;
  }
    public void Edgedraw() {     
           			int w =  bi.getWidth();
   	 			int h =  bi.getHeight();

    			BufferedImage output = new BufferedImage(w, h, bi.getType());

				for (int y = 1; y < h - 1; y++) 
					{
            			for (int x = 1; x < w - 1; x++) 
            			{
							int rgb = bi.getRGB(x-1, y-1);
							Color c00 = new Color(rgb);
                			rgb = bi.getRGB(x-1, y);
                			Color c01 = new Color(rgb);
                                        
            		rgb = bi.getRGB(x-1, y+1);
             			Color c02 = new Color(rgb);
                                        
                			rgb = bi.getRGB(x, y-1);                                    
               				Color c10 = new Color(rgb);
                                        
                                                    rgb = bi.getRGB(x, y);
                                            Color c11 = new Color(rgb);
                                        
                		rgb = bi.getRGB(x, y+1);
                			Color c12 = new Color(rgb);
                                        
                			rgb = bi.getRGB(x+1, y-1);
                			Color c20 = new Color(rgb);
                                        
                			rgb = bi.getRGB(x+1, y);
                			Color c21 = new Color(rgb);
                                        
                			rgb = bi.getRGB(x+1, y+1);
                			Color c22 = new Color(rgb);
                
                			int r = -c00.getRed() -   c01.getRed() - c02.getRed() +
                        			-c10.getRed() + 8*c11.getRed() - c12.getRed() +
                        			-c20.getRed() -   c21.getRed() - c22.getRed();
                			int g = -c00.getGreen() -   c01.getGreen() - c02.getGreen() +
                        			-c10.getGreen() + 8*c11.getGreen() - c12.getGreen() +
                        			-c20.getGreen() -   c21.getGreen() - c22.getGreen();
                			int b = -c00.getBlue() -   c01.getBlue() - c02.getBlue() +
                        			-c10.getBlue() + 8*c11.getBlue() - c12.getBlue() +
                        			-c20.getBlue() -   c21.getBlue() - c22.getBlue();
                
                			r = Math.min(255, Math.max(0, r));
                			g = Math.min(255, Math.max(0, g));
                			b = Math.min(255, Math.max(0, b));
               				
                			rgb = (0xff000000) | (r << 16) | (g << 8) | (b << 0);
  
                			output.setRGB(x, y, rgb);
            			}
        			}

    			bi=output;
  		}
  		
    
    public void Posterise() {
		int w =  bi.getWidth();
    int h =  bi.getHeight();

    BufferedImage dest = new BufferedImage(w, h, bi.getType());
 
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
 
				int px = bi.getRGB(x, y);
 
				int alpha = ((px >> 24) & 0xFF);
				int red = ((px >> 16) & 0xFF);
				int green = ((px >> 8) & 0xFF);
				int blue = (px & 0xFF);
				
                                if (red<= 127)
                                        red = 0;
                                else red=255;

                                if (green <= 127)
                                        green = 0;
                                else green=255;

                                if (blue<= 127)
                                    blue = 0;
                                else
                                    blue = 255;

				
			 px= (alpha<<24) + (red<<16) + (green<<8) + (blue<<0);
 
				dest.setRGB(x, y, px);
			}
		}
 
		bi= dest;
}

    
        }
    
    

    
    
    
    
    
    
    
    
    
    


   
    