package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class HomeTemplateFacade {

    private Light light;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;
    private Sound sound;
    private TVPlayer play;

    public HomeTemplateFacade() {
        light = Light.getInstance();
        popcorn = Popcorn.getInstance();
        projector = Projector.getInstance();
        screen = Screen.getInstance();
        sound = Sound.getInstance();
        play = TVPlayer.getInstance();
    }

    public void ready() {
        popcorn.putMaterial();
        popcorn.bake();
        light.on();
        projector.on();
        screen.up();
        sound.up();
        play.on();
        popcorn.pop();
    }
    public void play() {
        projector.focus();
        play.play();
    }
    public void pause() {
        play.pause();
    }
    public void end() {
        light.off();
        projector.off();
        screen.down();
        sound.down();
        play.off();
    }
}
