/*******************************************************************************
 * Copyright 2015 NEGU Soft
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.negusoft.greenmatter.interceptor.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.MatResources;
import com.negusoft.greenmatter.R;
import com.negusoft.greenmatter.drawable.RoundRectDrawable;
import com.negusoft.greenmatter.drawable.UnderlineDrawable;

public class UnderlineDrawableInterceptor implements DrawableInterceptor {

    public void setupInterceptors(DrawableInterceptorHelper helper) {
        helper.putInterceptor(R.drawable.gm__btn_toggle_indicator_default_reference, this);
        helper.putInterceptor(R.drawable.gm__btn_toggle_indicator_checked_reference, this);
        helper.putInterceptor(R.drawable.gm__cab_background_top_reference, this);
    }

    @Override
    public Drawable getDrawable(Resources res, MatPalette palette, int resId) {
        // Toggle indicator
        if (resId == R.drawable.gm__btn_toggle_indicator_default_reference)
            return new UnderlineDrawable(res, palette.getColorControlNormal(), 2f);
        if (resId == R.drawable.gm__btn_toggle_indicator_checked_reference)
            return new UnderlineDrawable(res, palette.getColorControlActivated(), 2f);

        // ActionMode background
        if (resId == R.drawable.gm__cab_background_top_reference)
            return new UnderlineDrawable(res, palette.getColorControlActivated(), 2.5f);

        return null;
    }

}
