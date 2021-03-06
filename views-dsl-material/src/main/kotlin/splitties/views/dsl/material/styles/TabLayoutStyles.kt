package splitties.views.dsl.material.styles

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.google.android.material.tabs.TabLayout
import splitties.views.dsl.core.NO_THEME
import splitties.views.dsl.core.styles.styledView
import splitties.views.dsl.material.R

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class TabLayoutStyles @PublishedApi internal constructor(
    @PublishedApi internal val ctx: Context
) {
    inline fun default(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: TabLayout.() -> Unit = {}
    ): TabLayout = ctx.styledView(
        newViewRef = ::TabLayout,
        styleAttr = R.attr.Widget_MaterialComponents_TabLayout,
        id = id,
        theme = theme,
        initView = initView
    )

    inline fun colored(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: TabLayout.() -> Unit = {}
    ): TabLayout = ctx.styledView(
        newViewRef = ::TabLayout,
        styleAttr = R.attr.Widget_MaterialComponents_TabLayout_Colored,
        id = id,
        theme = theme,
        initView = initView
    )
}
