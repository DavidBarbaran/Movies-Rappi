package com.rappi.movies.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.constraintlayout.widget.ConstraintLayout
import com.rappi.movies.R
import com.rappi.movies.presentation.util.hideKeyboard
import com.rappi.movies.presentation.util.showKeyboard
import kotlinx.android.synthetic.main.search_view.view.*

class SearchBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var isEnabledSearch = true

    init {
        View.inflate(context, R.layout.search_view, this)
        setAttr(attrs)
        setUI()
    }

    private fun setAttr(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.SearchBarView, 0, 0
        )

        try {
            typedArray.apply {
                isEnabledSearch = getBoolean(R.styleable.SearchBarView_is_enabled_search, true)
            }
        } catch (ex: Exception) {
            Log.e(this.javaClass.name, ex.message, ex)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setUI() {
        etSearch?.isFocusable = isEnabledSearch
        etSearch?.isLongClickable = isEnabledSearch
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        btnSearch?.setOnClickListener(l)
        etSearch?.setOnClickListener(l)
    }

    fun onActionSearch(performSearch: () -> Unit) {
        etSearch.setOnEditorActionListener { _, actionId, _ ->
            when(actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    performSearch.invoke()
                    true
                }
                else -> false
            }
        }
    }

    fun showKeyboard() {
        etSearch.requestFocus()
        showKeyboard(context)
    }

    fun hideKeyboard() {
        etSearch.clearFocus()
        etSearch.hideKeyboard(context)
    }

    fun getText() = etSearch?.text.toString().trim()
}