(ns aoc.core
  (:require [aoc.day1]
            [aoc.day02]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Advent of Code 2022"
  []
  (println (aoc.day02/part1 (read-input "day02-example.txt"))))
