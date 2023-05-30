package model.logic;

import app.App;

public interface Controller {
    App app = Singleton.getInstance().getApp();
}
