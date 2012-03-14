
package logic;

/**
 *
 * @author hamid
 */
public enum MirrorList implements Hosts {
    KENT{
        @Override
        public String getHost(){
            return "http://kent.dl.sourceforge";
        }
    },
    CITYLAN{
        @Override
        public String getHost(){
            return "http://citylan.dl.sourceforge.net";
        }
        
    }
    
}
