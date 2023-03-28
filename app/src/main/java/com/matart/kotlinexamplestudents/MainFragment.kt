package com.matart.kotlinexamplestudents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matart.kotlinexamplestudents.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var counter = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        // Конструкция with помогает сократить использование повторяющихся обращений к переменной/классу и тд
        with(binding) {

            // Использование лямбда-функции (анонимная функция) в качестве параметра действия onClickListener
            btnCounter.setOnClickListener {
                counter++
                // property-access syntax, позволяет избежать излишних обращений к геттеру/сеттеру поля
                tvCounter.text = counter.toString()
            }
        }

        return binding.root
    }
}