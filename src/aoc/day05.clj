(ns aoc.day05
  (:require [clojure.string]))

(defn- read-stack
  "Map the nth item in each row into a single result collection. In other words, it parses the nth column."
  [n stack-rows]
  ; if input is '[a] [b]' then 'a' and 'b' are at index 4n+1 when n = 0 or 1
  (let [char-index (+ (* 4 n) 1)]
    (map #(nth % char-index " ") stack-rows)))

(defn- parse-move-line
  [line]
  (let [matches (rest (re-find #"move (\d+) from (\d+) to (\d+)" line))
        numbers (map #(Integer/parseInt %) matches)]
    (zipmap [:amount :from-index :to-index] numbers)))

(defn- parse-move-lines
  [move-lines]
  (map parse-move-line move-lines))

(defn- parse-input
  [input]
  (let [input-parts (clojure.string/split input #"\n\n")
        stack-part (clojure.string/split (first input-parts) #"\n")
        stack-lines (butlast stack-part)
        index-line (last stack-part)
        last-index (Integer/parseInt (str (last index-line)))
        moves-lines (clojure.string/split (second input-parts) #"\n")]
    {:stacks stack-lines
     :indices (range last-index)
     :moves (parse-move-lines moves-lines)}))

(defn part1
  "Day 05 Part 1"
  [input]
  (parse-input input))

(defn part2
  "Day 05 Part 2"
  [input]
  input)

