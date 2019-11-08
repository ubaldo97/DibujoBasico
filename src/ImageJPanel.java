    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
     
    import javax.imageio.ImageIO;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
     
    @SuppressWarnings("serial")
    public class ImageJPanel extends JFrame {
     
     
    	public static void main(String... args) {
    		new ImageJPanel();
    	}
     
    	public ImageJPanel() {
    		super("Dibujo sobre imagen");
     
    		this.add(new PanelOverDraw());
    		this.setSize(484,519);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.setVisible(true);
    	}
     
    	public class PanelOverDraw extends JPanel {
     
     
    		private BufferedImage img = null;
     
    		public PanelOverDraw() {
     
    			File imageFile = new File("IF-180.jpg"); // guarda la imagen en un archivo
    			try {
    				img = ImageIO.read(getClass().getResourceAsStream(imageFile.toString())); // la carga en una BufferedReader
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
     
    			this.setPreferredSize(new Dimension(484,409));
     
    			// creamos una instancia graphics desde la imagen para pintar sobre ella
    			Graphics2D pint = img.createGraphics();
    		        pint.setColor(Color.GREEN);
    		        pint.fillRect(100,100,300,300);
    		        pint.dispose();
     
    		}
     
    		@Override
    		public void paintComponent(Graphics g)
    		{
    			super.paintComponent(g);
    			g.drawImage(img,0,0,null); // dibuja la imagen al iniciar la aplicacion
    		}
     
    	}
    }
     
