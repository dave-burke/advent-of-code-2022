(ns aoc.core
  (:require [aoc.day1]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "I don't do a whole lot."
  []
  (println (aoc.day1/part1 (read-input "day01-example.txt"))))
