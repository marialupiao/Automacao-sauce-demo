package br.sefaz.com.evidencias.evidence;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public final class SelecaoEvidencia {

	    private String sel_message;

	    private String imageString;

	    private BufferedImage image;

	    public SelecaoEvidencia(String message, String imageString) throws Exception {
	        setMessage(message);
	        setImageString(imageString);
	    }


	    public String getMessage() {
	        return sel_message;
	    }

	    public void setMessage(String message) {
	        this.sel_message = message;
	    }

	    public BufferedImage getImage() {
	        return image;
	    }

	    public void setImage(BufferedImage image) {
	        this.image = image;
	    }

	    public String getImageString() {
	        return imageString;
	    }

	    public void setImageString(String imageString) throws IOException, Exception {
			try {
				this.setImage(ImageIO.read(new ByteArrayInputStream(toImage(imageString))));
			} catch (Exception var3) {
				var3.printStackTrace();
			}

		}

	public static byte[] toImage(String string) throws Exception {
	        return Base64.decodeBase64(string);
	    }
	}
