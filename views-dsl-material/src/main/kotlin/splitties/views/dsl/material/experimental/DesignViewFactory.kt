/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package splitties.views.dsl.material.experimental

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.annotation.AttrRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.ConfigChangesHandlingCollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import splitties.experimental.InternalSplittiesApi
import splitties.views.dsl.material.fixedimpls.FixedAppBarLayoutBehavior

@InternalSplittiesApi
inline fun <reified V : View> instantiateMaterialView(
    clazz: Class<out V>,
    context: Context
): V? = when (clazz) {
    Button::class.java -> MaterialButton(context)
    FloatingActionButton::class.java -> FloatingActionButton(context)
    MaterialCardView::class.java -> MaterialCardView(context)
    AppBarLayout::class.java -> object : AppBarLayout(context), CoordinatorLayout.AttachedBehavior {
        override fun getBehavior(): CoordinatorLayout.Behavior<*> = FixedAppBarLayoutBehavior()
    }
    NavigationView::class.java -> NavigationView(context)
    BottomNavigationView::class.java -> BottomNavigationView(context)
    CollapsingToolbarLayout::class.java -> ConfigChangesHandlingCollapsingToolbarLayout(
        context
    )
    TabLayout::class.java -> TabLayout(context)
    TextInputLayout::class.java -> TextInputLayout(context)
    TextInputEditText::class.java -> TextInputEditText(context)
    else -> null
} as V?

@InternalSplittiesApi
inline fun <reified V : View> instantiateThemeAttrStyledMaterialView(
    clazz: Class<out V>,
    context: Context,
    @AttrRes styleThemeAttribute: Int
): V? = when (clazz) {
    Button::class.java -> MaterialButton(context, null, styleThemeAttribute)
    FloatingActionButton::class.java -> FloatingActionButton(context, null, styleThemeAttribute)
    MaterialCardView::class.java -> MaterialCardView(context, null, styleThemeAttribute)
    AppBarLayout::class.java -> object : AppBarLayout(context), CoordinatorLayout.AttachedBehavior {
        override fun getBehavior(): CoordinatorLayout.Behavior<*> = FixedAppBarLayoutBehavior()
    }
    NavigationView::class.java -> NavigationView(context, null, styleThemeAttribute)
    BottomNavigationView::class.java -> BottomNavigationView(context, null, styleThemeAttribute)
    CollapsingToolbarLayout::class.java -> ConfigChangesHandlingCollapsingToolbarLayout(
        context, null, styleThemeAttribute
    )
    TabLayout::class.java -> TabLayout(context, null, styleThemeAttribute)
    TextInputLayout::class.java -> TextInputLayout(context, null, styleThemeAttribute)
    TextInputEditText::class.java -> TextInputEditText(context, null, styleThemeAttribute)
    else -> null
} as V?
