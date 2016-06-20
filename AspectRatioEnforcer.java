import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AspectRatioEnforcer extends ComponentAdapter
{
       float aspectRatio;

       public AspectRatioEnforcer(float theAspectRatio)
       {
                aspectRatio = theAspectRatio;
       }

       @Override
       public void componentResized(ComponentEvent e)
       {
                Component theComponent = e.getComponent();
                int width = theComponent.getWidth();
                int height = theComponent.getHeight();
                float currentAspectRatio = (float) width / height;

                if (currentAspectRatio > aspectRatio)
                {
                         width = (int) (height * aspectRatio);
                }
                else
                {
                         height = (int) (width / aspectRatio);
                }
                theComponent.removeComponentListener(this);
                theComponent.setSize(width, height);
                theComponent.addComponentListener(this);
       }
}