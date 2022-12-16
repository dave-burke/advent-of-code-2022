(ns aoc.core
  (:require [aoc.day1]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Advent of Code 2022"
  []
  (println (aoc.day1/part1 (read-input "day01.txt"))))
