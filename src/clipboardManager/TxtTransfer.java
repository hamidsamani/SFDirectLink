
package clipboardManager;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamid
 */
public final class TxtTransfer {

    private Clipboard clipboardAsClipBoard;
    private Transferable currentValue;
    private String clipboardAsString = null;

    public TxtTransfer() {
        refreshClipboard();
    }

    public void refreshClipboard() {

        clipboardAsClipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        currentValue = clipboardAsClipBoard.getContents(null);

        if (currentValue.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                clipboardAsString = (String) currentValue.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(TxtTransfer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
           
            System.out.println("Don't contain thing any");
        }

    }

    public String getClipboard() {
        if (clipboardAsString.isEmpty()) {
            return "Could not Create Link";
        } else {
            return clipboardAsString;
        }
    }
}
