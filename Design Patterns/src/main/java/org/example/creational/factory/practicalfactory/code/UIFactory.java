package org.example.creational.factory.practicalfactory.code;

import org.example.creational.factory.practicalfactory.code.components.button.Button;
import org.example.creational.factory.practicalfactory.code.components.dropdown.DropDown;
import org.example.creational.factory.practicalfactory.code.components.menu.Menu;

// this is our abstract factory
public interface UIFactory {
    public Button createButton();
    Menu createMenu();
    DropDown createDropDown();
}
