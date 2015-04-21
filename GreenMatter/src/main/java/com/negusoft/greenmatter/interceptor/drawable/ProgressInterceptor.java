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

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.MatResources;
import com.negusoft.greenmatter.R;
import com.negusoft.greenmatter.drawable.IndeterminateProgressBarDrawable;
import com.negusoft.greenmatter.drawable.ProgressBarCircleDrawable;
import com.negusoft.greenmatter.drawable.TintDrawableWrapper;
import com.negusoft.greenmatter.util.ColorUtils;

/** Drawables for the ProgressBar */
public class ProgressInterceptor implements DrawableInterceptor {

    public void setupInterceptors(DrawableInterceptorHelper helper) {
        helper.putInterceptor(R.drawable.gm__progress_horizontal_background_reference, this);
        helper.putInterceptor(R.drawable.gm__progress_horizontal_secondary_reference, this);
        helper.putInterceptor(R.drawable.gm__progress_horizontal_progress_reference, this);
        helper.putInterceptor(R.drawable.gm__progress_indeterminate_horizontal_item_reference, this);
        helper.putInterceptor(R.drawable.gm__progress_circle_item_reference, this);
    }

	@Override
	public Drawable getDrawable(Resources res, MatPalette palette, int resId) {
        // Horizontal (normal)
        if (resId == R.drawable.gm__progress_horizontal_background_reference) {
            int color = applyDisabledAlpha(palette.getColorControlNormal(), palette);
            return getProgressDrawable(res, color);
        }
        if (resId == R.drawable.gm__progress_horizontal_secondary_reference) {
            int color = applyDisabledAlpha(palette.getColorControlActivated(), palette);
            return getProgressDrawable(res, color);
        }
        if (resId == R.drawable.gm__progress_horizontal_progress_reference)
            return getProgressDrawable(res, palette.getColorControlActivated());

        // Horizontal (indeterminate)
        if (resId == R.drawable.gm__progress_indeterminate_horizontal_item_reference)
            return new IndeterminateProgressBarDrawable(res, palette);

        // Circle
        if (resId == R.drawable.gm__progress_circle_item_reference)
            return new ProgressBarCircleDrawable(res, palette);

		return null;
	}

    private Drawable getProgressDrawable(Resources res, int tintColor) {
        Drawable drawable = res.getDrawable(R.drawable.gm__progress_mtrl_alpha);
        ColorStateList colors = ColorStateList.valueOf(tintColor);
        return new TintDrawableWrapper(drawable, colors);
    }

    private int applyDisabledAlpha(int color, MatPalette palette) {
        return ColorUtils.applyColorAlpha(color, palette.getDisabledAlpha());
    }

}
