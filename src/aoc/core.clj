(ns aoc.core
  (:require [aoc.day01]
            [aoc.day02]
            [aoc.day03]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Advent of Code 2022"
  []
  (println (aoc.day03/part1 (read-input "day03.txt"))))
