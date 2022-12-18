(ns aoc.day04
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn parse-range
  [range-string] ; "2-4"
  (let [ends (str/split range-string #"-")]
    (map #(Integer/parseInt %) ends)))

(defn parse-line
  [line] ; "2-4,4-6"
  (let [ranges (str/split line #",")]
    (map parse-range ranges)))

(defn ranges-overlap?
  [a b]
  (let [a0 (nth a 0)
        a1 (nth a 1)
        b0 (nth b 0)
        b1 (nth b 1)]
    (or
      (and (<= a0 b0) (>= a1 b1))
      (and (<= b0 a0) (>= b1 a1)))))

(defn count-if
  [predicate col]
  (reduce + (map #(if (predicate %) 1 0) col)))

(defn part1
  "Day 04 Part 1"
  [input]
  (->> (str/split-lines input)
       (map parse-line)
       (count-if #(apply ranges-overlap? %))))

(defn part2
  "Day 04 Part 2"
  [input]
  input)

