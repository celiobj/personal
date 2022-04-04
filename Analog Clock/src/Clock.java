import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import javax.swing.*;
import static java.lang.Math.*;

class ClockComponent extends JComponent{

	private Calendar systemTime = Calendar.getInstance();
	private int centerX = 200 ;
	private int centerY = 200;
	BufferedImage clockFace ;
	

	@Override
	public void paint(Graphics g){
		Graphics2D graphics = (Graphics2D)g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (clockFace==null) {

			clockFace = new BufferedImage(400, 400, BufferedImage.BITMASK);
			Graphics2D face = clockFace.createGraphics();
			face.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			drawTiks(face);

			BasicStroke width = new BasicStroke(3);
			face.setStroke(width);
			face.setPaint(Color.BLACK);
			//face.drawOval(0, 0, 400, 400);
			drawHands(face, 0, 0, 0, 10);
		}

		graphics.drawImage(clockFace, null, 0, 0);
		drawSecond(graphics);
		drawMinute(graphics);
		drawHour(graphics);
		
	}

	private void drawSecond(Graphics2D graphics){
		int seconds = systemTime.get(Calendar.SECOND);
		int secondsAngle = seconds*6;
		drawHands(graphics, -30, 160, secondsAngle,1);
	}

	private void drawMinute(Graphics2D graphics){
		int minutes = systemTime.get(Calendar.MINUTE);
		double minuteAngle = (minutes)*6;
		drawHands(graphics, 0, 150, minuteAngle,2);
	}

	private void drawHour(Graphics2D graphics){
		int hours = systemTime.get(Calendar.HOUR);
		double hourAngle = (hours+ (double)(systemTime.get(Calendar.MINUTE))/60)*30;
		drawHands(graphics, 0, 110, hourAngle,4);
	}

	private void drawTiks(Graphics2D graphics){
		int x=0;
		
		while(true){
			int y =180;
			if(x%30==0)y=170;
			drawHands(graphics, y, 180, x,2);
			if (x==360) break;
			x += 6;

		}
	}


	//radius Measured From the Center of the Clock
	private void drawHands(Graphics2D graphics, int startRadius, int endRadius, double teta,int width){

		double radian = toRadians(teta-90);
		int startX = centerX+ (int)(startRadius*cos(radian));
		int startY = centerY+ (int)(startRadius*sin(radian));
		int endX = centerX+ (int)(endRadius*cos(radian));
		int endY = centerY+ (int)(endRadius*sin(radian));

		BasicStroke line = new BasicStroke(width,BasicStroke.JOIN_ROUND,BasicStroke.CAP_ROUND);
		graphics.setStroke(line);
		graphics.setPaint(Color.BLACK);
		graphics.drawLine(startX, startY, endX, endY);
	}

	ActionListener update = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			systemTime.setTimeInMillis(System.currentTimeMillis());
			repaint();
		}
	};


	Timer fireUpdate = new Timer(1000, update);
}


