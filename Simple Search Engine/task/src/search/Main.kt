package com.kotlin.tutorial

import java.io.File
import java.util.stream.Collectors

enum class Strategies(val value: String) {
    ALL("ALL"),
    ANY("ANY"),
    NONE("NONE")
}

fun main(args: Array<String>) {
    val arr = File(args[1]).readLines()

    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all persons")
    println("0. Exit")
    println("Press the number of line")

    loop@ while (true) {
        when (readLine()!!) {
            "1" -> findInfo(arr)
            "2" -> printPeople(arr)
            "0" -> { println("Bye!"); break@loop }
            else -> println("Incorrect option! Try again.")
        }
    }
}

fun printPeople(arr: List<String>) {
    for (person in arr) {
        println(person)
    }
}

fun buildMap(arr: List<String>): MutableMap<String, MutableList<Int>> {
    val map = mutableMapOf<String, MutableList<Int>>()
    for ((i, line) in arr.withIndex()) {
        for (token in line.split(" ")) {
            val lowerCaseToken = token.toLowerCase()
            if (map.containsKey(lowerCaseToken)) {
                map[lowerCaseToken]!!.add(i)
            } else {
                map[lowerCaseToken] = mutableListOf(i)
            }
        }
    }

    return map
}

fun findInfo(arr: List<String>) {
    println("Select a matching strategy: ALL, ANY, NONE")
    val strategy = readLine()!!.toUpperCase()

    println("Enter a name or email to search all suitable people.")
    val regex = readLine()!!.toLowerCase().split(" ")
    val map = buildMap(arr)

    when (strategy) {
        Strategies.ALL.name -> greedyStrategy(arr, map, regex)
        Strategies.ANY.name -> anyStrategy(arr, map, regex)
        Strategies.NONE.name -> noneStrategy(arr, map, regex)
    }
}

fun greedyStrategy(arr: List<String>, map: MutableMap<String, MutableList<Int>>, regex: List<String>) {
    val result = map.filterKeys { regex.contains(it) }

    val setOfLines = result.values.stream()
            .map { it.stream().collect(Collectors.toSet()) }
            .reduce { u, acc -> acc.intersect(u) }

    if (setOfLines.isPresent) {
        setOfLines.get().forEach { println(arr[it]) }
    } else {
        println("No matching people found.")
    }
}

fun anyStrategy(arr: List<String>, map: MutableMap<String, MutableList<Int>>, regex: List<String>) {
    val result = map.filterKeys { regex.contains(it) }

    val setOfLines = result.values.stream()
            .map { it.stream().collect(Collectors.toSet()) }
            .reduce { u, acc -> acc.union(u) }

    if (setOfLines.isPresent) {
        setOfLines.get().forEach { println(arr[it]) }
    } else {
        println("No matching people found.")
    }
}

fun noneStrategy(arr: List<String>, map: MutableMap<String, MutableList<Int>>, regex: List<String>) {
    val result = map.filterKeys { regex.contains(it) }

    if (result != map) {
        val setOfLines = map.values.stream()
                .flatMap { it.stream() }
                .filter { !result.values.stream()
                        .flatMap { i -> i.stream() }
                        .toArray()
                        .contains(it)
                }
                .collect(Collectors.toSet())
        setOfLines.forEach { println(arr[it]) }
    } else {
        println("No matching people found.")
    }
}