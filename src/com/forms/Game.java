package com.forms;

import com.forms.entity.Player;
import com.forms.main.Window;
import com.forms.main.Camera;
import com.forms.handlers.Controller;
import com.forms.enums.GameState;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import com.forms.gfx.Renderer;
import com.forms.handlers.Textures;
import com.forms.input.KeyInput;
import com.forms.input.MouseInput;
import com.forms.libs.Audio;
import com.forms.libs.Identities;
import com.forms.screens.LoadScreen;
import com.forms.screens.Menu;
import com.forms.screens.Options;
import com.forms.utils.AudioPlayer;
import com.forms.utils.ResourceLoader;
import com.forms.utils.Updater;
import com.forms.world.Level;
import java.awt.Graphics2D;
import org.lwjgl.openal.AL;

/**
 *
 * @author Bill Gan
 */
public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1080; // the width of the game window
    public static final int HEIGHT = WIDTH / 4 * 3; // creates a 4 by 3 ratio
    public static final String TITLE = "Forms Land";
    
    private static Game game = new Game();
    public static GameState state = GameState.LOADING;
    
    private boolean running = false;
    private Thread thread;
    private Renderer gfx;
    private Camera camera;
    private Menu menu;
    private Options options;
    private Controller controller = new Controller();
    private Textures tex;
    public Level levelOne;
    
    private int time = 100;
    private int counter = 0;
    
    public static Game getInstance(){
        return game;
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public Options getOptions(){
        return options;
    }
    
    public Controller getController(){
        return controller;
    }
    
    public Textures getTextureHandler(){
        return tex;
    }
    
    public void init(){
        /*ResourceLoader.loadImages();
        ResourceLoader.loadFonts();
        ResourceLoader.loadSounds();
        tex = new Textures();
        menu = new Menu();
        options = new Options();
        gfx = new Renderer();
        MouseInput mouse = new MouseInput();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        levelOne = new Level(1);
        
        //controller.addObject(new Player(100, 400, Identities.PLAYER, tex));
        //camera = new Camera(0, 0);
        
        AudioPlayer.playMusic(Audio.MUSIC_NEW_SPACE_STATION, 1f, 0.3f);
*/
        ResourceLoader.preLoad();
    }
    
    /*public void initCamera(){
        camera = new Camera(0, 0);
    }*/
    
    private void load(){
        switch(counter){
            case 0:
                LoadScreen.setMessage("Loading Sprites...");
                ResourceLoader.loadImages();  //Loads our images and sprites
                counter++;
                LoadScreen.loadMore();
                return;
            case 1:
                LoadScreen.setMessage("Loading Fonts...");
                ResourceLoader.loadFonts();  //Loads our fonts
                counter++;
                LoadScreen.loadMore();
                return;
            case 2:
                LoadScreen.setMessage("Loading Sounds...");
                ResourceLoader.loadSounds(); //Loads our sounds
                counter++;
                LoadScreen.loadMore();
                return;
            case 3:
                LoadScreen.setMessage("Loading Textures...");
                tex = new Textures();
                counter++;
                LoadScreen.loadMore();
                return;
            case 4:
                LoadScreen.setMessage("Creating Menu...");
                menu = new Menu();  //creates our menu
                counter++;
                LoadScreen.loadMore();
                return;
            case 5:
                LoadScreen.setMessage("Creating Options...");
                options = new Options(); //creates the options menu
                counter++;
                LoadScreen.loadMore();
                return;
            case 6:
                LoadScreen.setMessage("Loading GUI...");
                gfx = new Renderer();  //initializes our renderer
                counter++;
                LoadScreen.loadMore();
                return;
            case 7:
                LoadScreen.setMessage("Loading Levels...");
                MouseInput mouse = new MouseInput();  //local mouse input object is used instead of an anonymous inner type so we may have multiple mouse listeners working together better
                this.addMouseListener(mouse); //adds a listener to listen for clicking of mouse buttons
                this.addMouseMotionListener(mouse);  //adds a listener to listen for mouse motion
                levelOne = new Level(1);
                counter++;
                LoadScreen.loadMore();
                return;
            case 8:
                LoadScreen.setMessage("Preparing Game Mechanics...");
                controller.addObject(new Player(100,HEIGHT - 300, Identities.PLAYER, tex));
                camera = new Camera(0,0);  //this must be initialized AFTER the controller
                this.addKeyListener(new KeyInput());
                counter++;
                LoadScreen.loadMore();
                return;
            case 9:
                LoadScreen.setMessage("Checking for Updates...");
                Updater.checkForUpdate(true);
                counter++;
                LoadScreen.loadMore();
                return;
            case 10:
                counter++;
                LoadScreen.loadMore();
                state = GameState.MENU;
                AudioPlayer.playMusic(Audio.MUSIC_NEW_SPACE_STATION);  //Plays our music
                return;
        }
    }
    
    /*public void addKeys(){
        this.addKeyListener(new KeyInput());
    }*/
    
    public void tick(){
        if(state == GameState.LOADING){
            time--;
            if(time <= 0){
                load();
                time = 50;
            }
        }
        if(state == GameState.GAME){
            controller.tick();
            camera.tick();
        }
    }
    
    public void render(){
        BufferStrategy bufferstrategy = this.getBufferStrategy();
        if(bufferstrategy == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bufferstrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        //SETTING GAME BACKGROUND COLOUR
        g.setColor(new Color(176, 226, 255));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        if(state == GameState.LOADING)
            LoadScreen.render(g);
        else{
            gfx.renderBackground(g);
            if(camera != null)
                g2d.translate(camera.getX(), camera.getY()); //do this before the foreground and after the background
            gfx.renderForeground(g);
            if(camera != null)
                g2d.translate(-camera.getX(), -camera.getY());  //do this after the foreground
        }
        
        /*gfx.renderBackground(g);
        if(camera != null)
            g2d.translate(camera.getX(), camera.getY());
        gfx.renderForeground(g);
        if(camera != null)
            g2d.translate(-camera.getX(), -camera.getY());
        */
        g.dispose();
        bufferstrategy.show();
    }
    
    @Override
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double numTicks = 60.0;
        double n = 1000000000 / numTicks;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / n;
            lastTime = currentTime;
            
            if(delta >= 1){
                tick();
                ticks++;
                delta--;
            }
            
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer >= 1000){
                if(counter >= 6){
                    if(options.showfps.isToggled()){
                //System.out.printf("Ticks: %d FPS: %d\n", ticks, frames);
                Window.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: " + frames);
                options.showfps.setText("Hide FPS");
                } else {
                    Window.setTitle(TITLE);
                    options.showfps.setText("Show FPS");
                }
                timer += 1000;
                ticks = 0;
                frames = 0;
                }
            }
        }
        stop();
    }
    
    public static void main(String args[]) {
        Window.initWindow(TITLE);
        Window.addGame(game);
        Window.createWindow();
        game.start();
        
    }
    
    private synchronized void start(){
        if(running)
            return;
        else
            running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop(){
        if(!running)
            return;
        else
            running = false;
        
        cleanUp();
        System.exit(0);
    }
    
    private void cleanUp(){
        AL.destroy();
    }
    
    public static void exit(){
        game.stop();
    }
    
}
