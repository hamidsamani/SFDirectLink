/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import clipboardManager.TxtTransfer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamid
 */
public class ParseLink {

    private TxtTransfer clipboardText;
    private String receivedLinkAsString;
    private URI receveidLinkAsLink;

    public ParseLink() {
        clipboardText = new TxtTransfer();
        receivedLinkAsString = clipboardText.getClipboard();
        try {
            receveidLinkAsLink = new URI(receivedLinkAsString);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ParseLink.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("check here if couldnot convert string to uri");
        }
    }

    public boolean isSourceforgeDomain() {
        if (receveidLinkAsLink.getHost().startsWith("sourceforge.net")
                || receveidLinkAsLink.getHost().startsWith("www.sourceforge.net")) {
            return true;

        }
        return false;
    }

    public int getPageState() {
        if (isSourceforgeDomain()) {
            //TODO write regex for project home page
            if (true) {
                return 1;
                //TODO regex project download page
            } else if (true) {
                return 2;
                //TODO regex forbidden page
            } else if (true) {
                return 3;
            }
        }
        return 0;
    }
}
