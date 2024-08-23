package org.example.creational.factory.abstractfactory.code;

import org.example.creational.factory.abstractfactory.code.components.button.Button;
import org.example.creational.factory.abstractfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.abstractfactory.code.components.menu.Menu;

// this is our abstract factory
public interface UIFactory {
    public Button createButton();
    Menu createMenu();
    DropDown createDropDown();
}
