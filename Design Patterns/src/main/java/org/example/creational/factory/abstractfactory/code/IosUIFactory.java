package org.example.creational.factory.abstractfactory.code;

import org.example.creational.factory.abstractfactory.code.components.button.AndroidButton;
import org.example.creational.factory.abstractfactory.code.components.button.Button;
import org.example.creational.factory.abstractfactory.code.components.button.IosButton;
import org.example.creational.factory.abstractfactory.code.components.dropdown.AndroidDropDown;
import org.example.creational.factory.abstractfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.abstractfactory.code.components.dropdown.IosDropDown;
import org.example.creational.factory.abstractfactory.code.components.menu.AndroidMenu;
import org.example.creational.factory.abstractfactory.code.components.menu.IosMenu;
import org.example.creational.factory.abstractfactory.code.components.menu.Menu;

public class IosUIFactory implements UIFactory{

    @Override
    public IosButton createButton() {
        return new IosButton();
    }

    @Override
    public IosMenu createMenu() {
        return new IosMenu();
    }

    @Override
    public IosDropDown createDropDown() {
        return new IosDropDown();
    }
}
