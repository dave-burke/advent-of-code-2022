(ns aoc.day05
  (:require [clojure.string]))

(defn- without-spaces
  "Removes spaces from a collection of characters"
  [col]
  (filter #(not= \space %) col))

(defn- read-stack
  "Map the nth item in each row into a single result collection. In other words, it parses the nth column."
  [n stack-rows]
  ; if input is '[a] [b]' then 'a' and 'b' are at index 4n+1 when n = 0 or 1
  (let [char-index (+ (* 4 n) 1)
        column (map #(nth % char-index \space) stack-rows)
        stack (without-spaces column)]
    stack))

(defn- parse-stacks
  "Reads each column (by index in indices) as a list"
  [stack-lines indices]
  (let [stacks (map #(read-stack % stack-lines) indices)
        column-labels (map #(+ % 1) indices)] ; column labels start at 1
    (zipmap column-labels stacks)))

(defn- parse-move-line
  "Returns the amount, from-index, and to-index of the line."
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
    {:stacks (parse-stacks stack-lines (range last-index))
     :moves (parse-move-lines moves-lines)}))

(defn- move-crate
  ([stack-map from-index to-index]
   (let [from-stack (get stack-map from-index)
         crate (first from-stack)
         new-from-stack (rest from-stack)
         to-stack (get stack-map to-index)
         new-to-stack (conj to-stack crate)]
     (assoc (assoc stack-map from-index new-from-stack) to-index new-to-stack))))

(defn- move-crates
  [stack-map move]
  (nth (iterate #(move-crate % (:from-index move) (:to-index move)) stack-map) (:amount move)))

(defn- print-stacks
  [stack-map]
  (doseq [[k v] (map identity stack-map)]
          (println k (reverse v))))

(defn- print-moves
  [moves]
  (doseq [move moves]
    (let [amount (:amount move)
          from (:from-index move)
          to (:to-index move)]
      (println "move" amount "from" from "to" to))))

(defn part1
  "Day 05 Part 1"
  [input]
  (let [input-model (parse-input input)
        result-stacks (reduce move-crates (:stacks input-model) (:moves input-model))]
        (clojure.string/join (map first (vals result-stacks)))))

(defn part2
  "Day 05 Part 2"
  [input]
  input)

