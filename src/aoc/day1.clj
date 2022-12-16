(ns aoc.day1
  (:require [clojure.string :as str]))

(defn strings-to-numbers
  [strings]
  (map #(Integer/parseInt %) strings))

(defn part1
  "Day 01 Part 1"
  [input]
  (->> (str/split input #"\n\n")
       (map #(str/split % #"\n"))
       (map strings-to-numbers)
       (map #(reduce + %))
       (reduce (fn [a b] (if (> a b) a b)))))

