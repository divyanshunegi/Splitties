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

package xyz.louiscad.splittiessample.ui.activity

import android.os.Build.VERSION.SDK_INT
import android.support.design.widget.AppBarLayout
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.NestedScrollView
import android.view.Gravity
import splitties.dimensions.dip
import splitties.resources.dimenPxSize
import splitties.resources.styledColor
import splitties.resources.styledColorSL
import splitties.viewdsl.appcompat.button
import splitties.viewdsl.appcompat.styles.coloredButton
import splitties.viewdsl.appcompat.textView
import splitties.viewdsl.core.Ui
import splitties.viewdsl.core.add
import splitties.viewdsl.core.lParams
import splitties.viewdsl.core.margin
import splitties.viewdsl.core.matchParent
import splitties.viewdsl.core.v
import splitties.viewdsl.core.verticalLayout
import splitties.views.appcompat.Toolbar
import splitties.views.imageResource
import splitties.views.setCompoundDrawables
import splitties.views.textResource
import xyz.louiscad.splittiessample.R
import splitties.viewdsl.design.lParams as dLParams

class MainUi(override val ctx: MainActivity) : Ui {

    val content = v(::NestedScrollView) {
        add(::verticalLayout, lParams(width = matchParent)) {
            add(::coloredButton, R.id.launchDemoButton, lParams {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(8)
            }) {
                textResource = R.string.go_to_the_demo
            }
            add(::button, R.id.toggle_night_mode_button, lParams {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(8)
            }) {
                compoundDrawablePadding = dip(4)
                if (SDK_INT >= 23) compoundDrawableTintList = styledColorSL(android.R.attr.textColorSecondary)
                setCompoundDrawables(start = R.drawable.ic_invert_colors_white_24dp)
                textResource = R.string.toggle_night_mode
            }
            add(::button, R.id.concurrency_test_button, lParams {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(8)
            }) {
                textResource = R.string.test_concurrency
            }
            add(::textView, lParams {
                margin = dimenPxSize(R.dimen.text_margin)
            }) {
                textResource = R.string.large_text
            }
        }
    }

    override val root = v(::CoordinatorLayout) {
        fitsSystemWindows = true
        add(::AppBarLayout, R.id.app_bar, R.style.AppTheme_AppBarOverlay,
                dLParams(width = matchParent, height = dip(180))) {
            add(::CollapsingToolbarLayout, dLParams(height = matchParent) {
                scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
            }) {
                fitsSystemWindows = true
                setContentScrimColor(styledColor(R.attr.colorPrimary))
                add(::Toolbar, dLParams(width = matchParent) {
                    collapseMode = COLLAPSE_MODE_PIN
                }) {
                    popupTheme = R.style.AppTheme_PopupOverlay
                    ctx.setSupportActionBar(this)
                }
            }
        }
        add(content, dLParams(width = matchParent, height = matchParent) {
            behavior = AppBarLayout.ScrollingViewBehavior()
        })
        add(::FloatingActionButton, dLParams {
            anchorId = R.id.app_bar
            anchorGravity = Gravity.BOTTOM or Gravity.END
            margin = dip(16)
        }) {
            imageResource = R.drawable.ic_favorite_white_24dp
        }
    }
}
