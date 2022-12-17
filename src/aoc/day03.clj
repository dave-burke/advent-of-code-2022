(ns aoc.day03
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn split-lines
  [input]
  (str/split input #"\n"))

(defn split-in-half
  [line]
  (let [half-length (/ (count line) 2)]
    [(take half-length line) (drop half-length line)]))

(defn to-sets
  [lists]
  (map set lists))

(defn to-intersections
  [sets]
  (first (set/intersection (first sets) (first (rest sets)))))

(defn to-priorities
  [character]
  (let [charCode (int character)]
    ; In ASCII A-Z = 65-90 and a-z = 97-122
    (if (< charCode 97)  ; if capital letter
      (- charCode 38)    ; convert capital to 27-52
      (- charCode 96)))) ; convert lowercase to 1-26

(defn part1
  "Day 03 Part 1"
  [input]
  (->> (split-lines input) ; file -> [lines]
       (map split-in-half) ; [lines] -> [(half half)]
       (map to-sets) ; [(half half)] -> [#{half} #{half}]
       (map to-intersections) ; [#{half} #{half}] -> #{intersection}
       (map to-priorities) ; #{intersection} -> priority
       (reduce +))) ; sum

(defn split-by-three
  ([lines] (split-by-three [(take 3 lines)] (drop 3 lines)))
  ([groups remaining]
    (if (empty? remaining)
      groups
      (split-by-three (conj groups (take 3 remaining)) (drop 3 remaining)))))

(defn part2
  "Day 03 Part 2"
  [input]
  (->> (str/split-lines input)
       (map set)
       (split-by-three)
       (map (fn [group] (set/intersection (nth group 0) (nth group 1) (nth group 2))))
       (map first)
       (map to-priorities)
       (reduce +)))

