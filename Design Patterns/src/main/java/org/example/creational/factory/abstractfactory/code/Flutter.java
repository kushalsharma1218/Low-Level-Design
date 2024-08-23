package org.example.creational.factory.abstractfactory.code;

public class Flutter {
    public void setTheme(){}
    public void setRefreshRate(){}


    /*
    // we can do it like this, but this is prone to errors platform is being passed by client so, can pass anything
    public UIFactory getUIFactory(String platform){
        if(platform.equals("ANDROID")){
            return new AndroidUIFactory();
        }
        else {
            return new IosUIFactory();
        }
    }
     */

    /** But this is still violating OCP principle, some new platform comes up, and then we have to change existing code
     * we will remove this in practical factory
     * Flutter should now be responsible for this code
     * The correct place to handel this code is UiFactoryGenerator
     * */
    public UIFactory getUIFactory(PlatformEnum platform){
        if(platform == PlatformEnum.ANDROID){
            return new AndroidUIFactory();
        }
        else {
            return new IosUIFactory();
        }
    }
}
