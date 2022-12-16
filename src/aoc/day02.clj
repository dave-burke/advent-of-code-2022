(ns aoc.day02
  (:require [clojure.string :as str]))

;A Y
;B X
;C Z

; A = Rock, B = Paper, C = Scissors
; X = Rock, Y = Paper, Z = Scissors

(defn parse-lines-1 [lines]
  (let [results {
                "A X" [:rock :rock]
                "A Y" [:rock :paper]
                "A Z" [:rock :scissors]
                "B X" [:paper :rock]
                "B Y" [:paper :paper]
                "B Z" [:paper :scissors]
                "C X" [:scissors :rock]
                "C Y" [:scissors :paper]
                "C Z" [:scissors :scissors]
                }]
    (map #(results %) lines)))

(defn play-game [game]
  (let [results {
                [:rock :rock] 3
                [:rock :paper] 6
                [:rock :scissors] 0
                [:paper :rock] 0
                [:paper :paper] 3
                [:paper :scissors] 6
                [:scissors :rock] 6
                [:scissors :paper] 0
                [:scissors :scissors] 3
                }]
    (results game)))

(defn score-games [games]
  (map (fn [game]
         (let [score-for-game (play-game game)
               score-for-move (case (get game 1)
                                :rock 1
                                :paper 2
                                :scissors 3)]
           (+ score-for-move score-for-game)))
       games))

(defn part1
  "Day 02 Part 1"
  [input]
  (->> (str/split input #"\n")
       (parse-lines-1) ; line -> keys
       (score-games) ; keys -> score
       (reduce +))) ; sum

; X = Lose
; Y = Draw
; Z = Win
(defn parse-lines-2
  [lines]
  (let [results {
                "A X" [:rock :scissors]
                "A Y" [:rock :rock]
                "A Z" [:rock :paper]
                "B X" [:paper :rock]
                "B Y" [:paper :paper]
                "B Z" [:paper :scissors]
                "C X" [:scissors :paper]
                "C Y" [:scissors :scissors]
                "C Z" [:scissors :rock]
                }]
    (map #(results %) lines)))

(defn part2
  "Day 02 Part 2"
  [input]
  (->> (str/split input #"\n")
       (parse-lines-2) ; line -> keys
       (score-games) ; keys -> score
       (reduce +))) ; sum

