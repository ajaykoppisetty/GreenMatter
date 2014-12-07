package com.negusoft.greenmatter.activity;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;

import com.negusoft.greenmatter.MatHelper;
import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.MatResources;

/**
 * Extends the ActionBarActivity class and adds the GreenMatter configuration.
 */
public abstract class MatActivity extends ActionBarActivity {

    private final MatHelper mMatHelper = new MatHelper(new MyPaletteOverrider(), new MyInitListener());

    @Override
    public Resources getResources() {
        return mMatHelper.getResources(this, super.getResources());
    }

    /**
     * Override this method to set the palette colors programmatically.
     * @param palette The palette inflated from the theme.
     * @return A MatPalette instance with the desired colors
     */
    public MatPalette overridePalette(MatPalette palette) {
        return palette;
    }

    /** Getter for the MatHelper instance. */
    public MatHelper getMatHelper() {
        return mMatHelper;
    }

    /**
     * Override this function to modify the MatResources instance. You can add your own logic
     * to the default GreenMatter behaviour.
     */
    public void onInitMatResources(MatResources resources) {
        // To be overriden in child classes.
    }

    private class MyPaletteOverrider implements MatResources.PaletteOverrider {
        @Override
        public MatPalette getPalette(MatPalette palette) {
            return overridePalette(palette);
        }
    }

    private class MyInitListener implements MatHelper.OnInitListener {
        @Override
        public void onInitResources(MatResources resources) {
            onInitMatResources(resources);
        }
    }

}
