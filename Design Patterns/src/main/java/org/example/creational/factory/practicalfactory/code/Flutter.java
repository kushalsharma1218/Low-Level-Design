package org.example.creational.factory.practicalfactory.code;

public class Flutter {

    private PlatformEnum platform;
    public Flutter(PlatformEnum platformEnum){
        this.platform = platformEnum;
    }
    public void setTheme(){}
    public void setRefreshRate(){}


    /**
     * Here we still need platform right...
     * So lest that in Flutter constructor
     * @return
     */

    public UIFactory getUIFactory(){
        return UiFactoryGenerator.generateUIFactory(platform);
    }
}
