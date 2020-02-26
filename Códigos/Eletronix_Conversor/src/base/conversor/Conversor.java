package base.conversor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import base.conversor.*;



public class Conversor extends JFrame implements NativeMouseInputListener{
	
	private boolean isPressed;
	private int click = 0;
	private static GlobalScreen global;
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {}

	@Override
	public void nativeMouseMoved(NativeMouseEvent e) {
		if(isPressed){
			setBounds(e.getX(), e.getY(), 550, 350);
			
		}
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hexacolor = "green";
	private String bincolor = "green";
	private String deccolor = "green";
	private String hexaback = "black";
	private String binback = "black";
	private String decback = "black";
	private String aescolor = "green";
	private String aesback = "black";
	private boolean exchange = false;
	private String estate = "";
	private static String IV = "EletronixA9Yc00*";
    private String key = "realitynoexists*";
	
	public Conversor(){
		
		
		this.setTitle("Eletronix Conversor");
		this.setBounds(250, 190, 550, 350);
		this.setUndecorated(true);
		
		ImageIcon icon;
		icon = new ImageIcon(getClass().getResource("/base/image/Eletronix.png"));
		this.setIconImage(icon.getImage());
		
		ImageIcon image = new ImageIcon(this.getClass().getResource("/base/image/Setas.jpg"));
		image.setImage(image.getImage().getScaledInstance(30, 20, 100));
		
		JLabel back = new JLabel();
		back.setText("<html><div style='background:black;width:550;height:350;'></div></html>");
		back.setBounds(0, 0, 550, 350);
		back.setBorder(BorderFactory.createLineBorder(Color.green));
		this.add(back);
		
		JLabel head = new JLabel();
		head.setText("<html><div style='background:black;width:550;height:30;'></div></html>");
		head.setBounds(0, 0, 550, 25);
		head.setBorder(BorderFactory.createLineBorder(Color.green));
		back.add(head);
		
		JLabel title = new JLabel();
		title.setText("Eletronix Conversor");
		title.setForeground(Color.red);
		title.setBounds(20, 3, 140, 20);
		head.add(title);
		
		ImageIcon iconTitle1 = new ImageIcon(this.getClass().getResource("/base/image/Eletronix.png"));
		iconTitle1.setImage(iconTitle1.getImage().getScaledInstance(15, 15, 100));
		
		JLabel titleImg = new JLabel();
		titleImg.setText("<html><div style='background:black;width:15;height:20;'></div></html>");
		titleImg.setIcon(iconTitle1);
		titleImg.setForeground(Color.red);
		titleImg.setBounds(2, 2, 20, 20);
		head.add(titleImg);
		
		JLabel close = new JLabel();
		close.setText("<html><div style='background:black;color:red;width:20;height:20;padding-left:5;padding-top:2;'><b>X</b></div></html>");
		close.setForeground(Color.red);
		close.setBounds(528, 3, 20, 20);
		close.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		close.setBorder(BorderFactory.createLineBorder(Color.red));
		head.add(close);
		
		JLabel minimize = new JLabel();
		minimize.setText("<html><div style='background:black;color:red;width:20;height:20;padding-left:6;padding-top:1;'><b>-</b></div></html>");
		minimize.setForeground(Color.red);
		minimize.setBounds(504, 3, 20, 20);
		minimize.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		minimize.setBorder(BorderFactory.createLineBorder(Color.red));
		head.add(minimize);
		
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				close.setText("<html><div style='background:black;color:red;width:20;height:20;padding-left:5;padding-top:2;'><b>X</b></div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				close.setText("<html><div style='background:red;color:white;width:20;height:20;padding-left:5;padding-top:2;'><b>X</b></div></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		minimize.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				setExtendedState(JFrame.ICONIFIED);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				minimize.setText("<html><div style='background:black;color:red;width:20;height:20;padding-left:6;padding-top:1;'><b>-</b></div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				minimize.setText("<html><div style='background:red;color:white;width:20;height:20;padding-left:6;padding-top:1;'><b>-</b></div></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		head.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(click == 0){
					click = 1;
					isPressed = true;
					setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				}else{
					click = 0;
					isPressed = false;
					setCursor(null);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});

		JLabel backEditor1 = new JLabel();
		backEditor1.setText("<html><div style='background:red;width:250;height:280;'></div></html>");
		backEditor1.setBounds(5, 60, 240, 280);
		back.add(backEditor1);
		
		JLabel backEditor2 = new JLabel();
		backEditor2.setText("<html><div style='background:red;width:250;height:280;'></div></html>");
		backEditor2.setBounds(290, 60, 240, 280);
		back.add(backEditor2);
		
		JLabel convLabel1 = new JLabel();
		convLabel1.setBounds(5, 35, 50, 20);
		convLabel1.setForeground(Color.green);
		convLabel1.setText("");
		back.add(convLabel1);
		
		JLabel convLabel2 = new JLabel();
		convLabel2.setBounds(500, 35, 50, 20);
		convLabel2.setForeground(Color.green);
		convLabel2.setText("");
		back.add(convLabel2);
		
		JEditorPane editor1 = new JEditorPane();
		editor1.setForeground(Color.green);
		editor1.setBorder(BorderFactory.createLineBorder(Color.green));
		editor1.setBackground(Color.BLACK);
		
		JEditorPane editor2 = new JEditorPane();
		editor2.setForeground(Color.green);
		editor2.setEditable(false);
		editor2.setBorder(BorderFactory.createLineBorder(Color.green));
		editor2.setBackground(Color.BLACK);
		
		editor1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_CONTROL){
					char[] charEditor = editor1.getText().toCharArray();
					String armazenChar = "";
					String armazenChar1 = "";
					char chars;
					
					if(estate.equals("dec1")){
						for(int i = 0; i < editor1.getText().length(); i++){
							int j = (int) charEditor[i];
							armazenChar += j+" ";
						}
						editor2.setText(armazenChar+" "+"00");
					}else{
						if(estate.equals("dec2")){
							int intChar = 0;
							for(int i = 0; i < editor1.getText().length(); i++){
								
								if(charEditor[i] == ' ' || armazenChar.equals("00")){
					
									
									if(!armazenChar.equals("")){
										intChar = Integer.parseInt(armazenChar);
										chars = new Character((char) intChar);
										armazenChar1 += chars;
										armazenChar = "";
									}
								}else{
									armazenChar += charEditor[i];
								}
							}
							editor2.setText(armazenChar1);
							
						}else{
							if(estate.equals("bin1")){
								for(int i = 0; i < editor1.getText().length(); i++){
									int j = (int) charEditor[i];
									armazenChar += Integer.toBinaryString(j)+" ";
								}
								editor2.setText(armazenChar+" "+"0000000");
							}else{
								if(estate.equals("bin2")){
									int intChar = 0;
									for(int i = 0; i < editor1.getText().length(); i++){
										if(charEditor[i] == ' ' || armazenChar.equals("0000000")){
											
											
											if(!armazenChar.equals("")){
												intChar = Integer.valueOf(armazenChar, 2).intValue();
												chars = new Character((char) intChar);
												armazenChar1 += chars;
												armazenChar = "";
											}
										}else{
											armazenChar += charEditor[i];
										}
									}
									editor2.setText(armazenChar1);
								}else{
									if(estate.equals("hexa1")){
										for(int i = 0; i < editor1.getText().length(); i++){
											int j = (int) charEditor[i];
											armazenChar += Integer.toHexString(j)+" ";
										}
										editor2.setText(armazenChar+" "+"00");
									}else{
										if(estate.equals("hexa2")){
											int intChar = 0;
											for(int i = 0; i < editor1.getText().length(); i++){
												if(charEditor[i] == ' ' || armazenChar.equals("00")){
												
													
													if(!armazenChar.equals("")){
														intChar = Integer.valueOf(armazenChar, 16).intValue();
														chars = new Character((char) intChar);
														armazenChar1 += chars;
														armazenChar = "";
													}
												}else{
													armazenChar += charEditor[i];
												}
											}
											editor2.setText(armazenChar1);
										}else{
											if(estate.equals("aes1")){
												try {
								                    byte[] encrypted = encrypt(editor1.getText(), key);
								                  
								                    
													for(int i = 0; i < encrypted.length; i++){
														chars = new Character((char) encrypted[i]);
														armazenChar1 += chars;
													
													}	
													editor2.setText(armazenChar1);
													armazenChar1 = "";
								               
													} catch (Exception e) {
														e.printStackTrace();
													}
											}else{
												if(estate.equals("aes2")){
													byte[] value = new byte[editor1.getText().length()];
													for(int i = 0; i < editor1.getText().length(); i++){
														byte j = (byte) charEditor[i];
														armazenChar += j+" ";
														value[i] = j;
													}
									
													
													try {
														String decrypted = decrypt(value, key);
														
														editor2.setText(decrypted);
													} catch (Exception e) {
														e.printStackTrace();
													}
								                   
												}
											}
										}
									}
									
								}
							}
						}
					}
					
					
					
					armazenChar = "";
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		JScrollPane scroll1;
		scroll1 = new JScrollPane(editor1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll1.setBounds(0, 0, 240, 280);
		backEditor1.add(scroll1);
		
		
		
		
		JScrollPane scroll2;
		scroll2 = new JScrollPane(editor2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setBounds(0, 0, 240, 280);
		backEditor2.add(scroll2);
		
		JLabel aes = new JLabel();
		aes.setText("<html><div style='color:green;background:black;width:35;height:20;padding-left:5;'>AES</div></html>");
		aes.setBounds(250, 215, 35, 20);
		aes.setBorder(BorderFactory.createLineBorder(Color.green));
		aes.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		back.add(aes);
		
		JLabel hexa = new JLabel();
		hexa.setText("<html><div style='color:green;background:black;width:35;height:20;'>Hexa</div></html>");
		hexa.setBounds(250, 185, 35, 20);
		hexa.setBorder(BorderFactory.createLineBorder(Color.green));
		hexa.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		back.add(hexa);
		
		JLabel bin = new JLabel();
		bin.setText("<html><div style='color:green;background:black;width:35;height:20;padding-left:6;'>Bin</div></html>");
		bin.setBounds(250, 155, 35, 20);
		bin.setBorder(BorderFactory.createLineBorder(Color.green));
		bin.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		back.add(bin);
		
		JLabel dec = new JLabel();
		dec.setText("<html><div style='color:green;background:black;width:35;height:20;padding-left:5;'>Dec</div></html>");
		dec.setBounds(250, 125, 35, 20);
		dec.setBorder(BorderFactory.createLineBorder(Color.green));
		dec.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		back.add(dec);
		
		JLabel exc = new JLabel();
		exc.setText("<html><div style='color:green;background:black;width:35;height:20;'></div></html>");
		exc.setIcon(image);
		exc.setBounds(250, 95, 35, 20);
		exc.setBorder(BorderFactory.createLineBorder(Color.green));
		exc.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		back.add(exc);
		
		aes.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				aescolor = "white";
				aesback = "green";
				hexacolor = "green";
				hexaback = "black";
				bincolor = "green";
				binback = "black";
				deccolor = "green";
				decback = "black";
				aes.setText("<html><div style='color:"+aescolor+";background:"+aesback+";width:35;height:20;padding-left:5;'>AES</div></html>");
				bin.setText("<html><div style='color:"+bincolor+";background:"+binback+";width:35;height:20;padding-left:6;'>Bin</div></html>");
				hexa.setText("<html><div style='color:"+hexacolor+";background:"+hexaback+";width:35;height:20;'>Hexa</div></html>");
				dec.setText("<html><div style='color:"+deccolor+";background:"+decback+";width:35;height:20;padding-left:5;'>Dec</div></html>");
				
				if(!exchange){
					convLabel1.setText("Text");
					convLabel2.setText("Aes");
					estate = "aes1";
				}else{
					convLabel1.setText("Aes");
					convLabel2.setText("Text");
					estate = "aes2";
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				aes.setText("<html><div style='color:"+aescolor+";background:"+aesback+";width:35;height:20;padding-left:5;'>AES</div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				aes.setText("<html><div style='color:white;background:green;width:35;height:20;padding-left:5;'>AES</div></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		hexa.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				hexacolor = "white";
				hexaback = "green";
				bincolor = "green";
				binback = "black";
				deccolor = "green";
				decback = "black";
				aescolor = "green";
				aesback = "black";
				hexa.setText("<html><div style='color:"+hexacolor+";background:"+hexaback+";width:35;height:20;'>Hexa</div></html>");
				bin.setText("<html><div style='color:"+bincolor+";background:"+binback+";width:35;height:20;padding-left:6;'>Bin</div></html>");
				dec.setText("<html><div style='color:"+deccolor+";background:"+decback+";width:35;height:20;padding-left:5;'>Dec</div></html>");
				aes.setText("<html><div style='color:"+aescolor+";background:"+aesback+";width:35;height:20;padding-left:5;'>AES</div></html>");
				
				if(!exchange){
					convLabel1.setText("Text");
					convLabel2.setText("Hexa");
					estate = "hexa1";
				}else{
					convLabel1.setText("Hexa");
					convLabel2.setText("Text");
					estate = "hexa2";
				}
				
		
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				hexa.setText("<html><div style='color:"+hexacolor+";background:"+hexaback+";width:35;height:20;'>Hexa</div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				hexa.setText("<html><div style='color:white;background:green;width:35;height:20;'>Hexa</div></html>");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		bin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				bincolor = "white";
				binback = "green";
				hexacolor = "green";
				hexaback = "black";
				deccolor = "green";
				decback = "black";
				aescolor = "green";
				aesback = "black";
				bin.setText("<html><div style='color:"+bincolor+";background:"+binback+";width:35;height:20;padding-left:6;'>Bin</div></html>");
				hexa.setText("<html><div style='color:"+hexacolor+";background:"+hexaback+";width:35;height:20;'>Hexa</div></html>");
				dec.setText("<html><div style='color:"+deccolor+";background:"+decback+";width:35;height:20;padding-left:5;'>Dec</div></html>");
				aes.setText("<html><div style='color:"+aescolor+";background:"+aesback+";width:35;height:20;padding-left:5;'>AES</div></html>");
				
				if(!exchange){
					convLabel1.setText("Text");
					convLabel2.setText("Bin");
					estate = "bin1";
				}else{
					convLabel1.setText("Bin");
					convLabel2.setText("Text");
					estate = "bin2";
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				bin.setText("<html><div style='color:"+bincolor+";background:"+binback+";width:35;height:20;padding-left:6;'>Bin</div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				bin.setText("<html><div style='color:white;background:green;width:35;height:20;padding-left:6;'>Bin</div></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		dec.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				deccolor = "white";
				decback = "green";
				hexacolor = "green";
				hexaback = "black";
				bincolor = "green";
				binback = "black";
				aescolor = "green";
				aesback = "black";
				dec.setText("<html><div style='color:"+deccolor+";background:"+decback+";width:35;height:20;padding-left:6;'>Dec</div></html>");
				hexa.setText("<html><div style='color:"+hexacolor+";background:"+hexaback+";width:35;height:20;'>Hexa</div></html>");
				bin.setText("<html><div style='color:"+bincolor+";background:"+binback+";width:35;height:20;padding-left:6;'>Bin</div></html>");
				aes.setText("<html><div style='color:"+aescolor+";background:"+aesback+";width:35;height:20;padding-left:5;'>AES</div></html>");
				
				if(!exchange){
					convLabel1.setText("Text");
					convLabel2.setText("Dec");
					estate = "dec1";
				}else{
					convLabel1.setText("Dec");
					convLabel2.setText("Text");
					estate = "dec2";
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				dec.setText("<html><div style='color:"+deccolor+";background:"+decback+";width:35;height:20;padding-left:5;'>Dec</div></html>");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dec.setText("<html><div style='color:white;background:green;width:35;height:20;padding-left:6;'>Dec</div></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		exc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String exc1 = convLabel1.getText();
				String exc2 = convLabel2.getText();
				
				convLabel1.setText(exc2);
				convLabel2.setText(exc1);
				if(exchange == false){
					exchange = true;
					estate = estate.replace('1', '2');
				}else{
					exchange = false;
					estate = estate.replace('2', '1');
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exc.setBorder(BorderFactory.createLineBorder(Color.green));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exc.setBorder(BorderFactory.createLineBorder(Color.white));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
	}
	
	 public static byte[] encrypt(String text1, String key1) throws Exception {
         Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
         SecretKeySpec keys = new SecretKeySpec(key1.getBytes("UTF-8"), "AES");
         encripta.init(Cipher.ENCRYPT_MODE, keys,new IvParameterSpec(IV.getBytes("UTF-8")));
         return encripta.doFinal(text1.getBytes("UTF-8"));
	 }
	 
	 public static String decrypt(byte[] decrypted, String key) throws Exception{
         Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
         SecretKeySpec keys = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
         decripta.init(Cipher.DECRYPT_MODE, keys,new IvParameterSpec(IV.getBytes("UTF-8")));
         return new String(decripta.doFinal(decrypted),"UTF-8");
	 }
	
	public static void main(String[] args){
		
		try {
            GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
		}
		
		Conversor Eletronix = new Conversor();
		Eletronix.setVisible(true);
		
		try {
			global.registerNativeHook();
			global.addNativeMouseListener(Eletronix);
			global.addNativeMouseMotionListener(Eletronix);
		} catch (NativeHookException e) {
			e.printStackTrace();
		}


	}
	
}
