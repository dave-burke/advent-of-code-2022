(ns aoc.day06
  (:require [clojure.string]))

;(defn positive-numbers
	;([] (positive-numbers 1))
	;([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn window-scanner
  [window-size]
  (fn scan [col]
    (if (<= (count col) window-size)
      col
      (lazy-seq (cons (take window-size col) (scan (rest col)))))))

(defn all-unique?
  [col]
  (= (count col) (count (set col))))

(defn part1
  "Day 06 Part 1"
  [input]
  (first (filter all-unique? ((window-scanner 4) input))))

(defn part2
  "Day 06 Part 2"
  [input]
  input)

