(ns aoc.core
  (:require [aoc.day01]
            [aoc.day02]
            [aoc.day03]
            [aoc.day04]
            [aoc.day05]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Advent of Code 2022"
  ([day] (-main day "1" nil))
  ([day part] (-main day (Integer/parseInt part) nil))
  ([day part example]
    (let [input-file (str "day" day (if example "-example.txt" ".txt"))
          puzzle (str day "." part)]
      (println "Running Day" day "Part" part "as" puzzle "reading" input-file)
      (let [result (case puzzle
                     "01.1" (aoc.day01/part1 (read-input input-file))
                     "01.2" (aoc.day01/part2 (read-input input-file))
                     "02.1" (aoc.day02/part1 (read-input input-file))
                     "02.2" (aoc.day02/part2 (read-input input-file))
                     "03.1" (aoc.day03/part1 (read-input input-file))
                     "03.2" (aoc.day03/part2 (read-input input-file))
                     "04.1" (aoc.day04/part1 (read-input input-file))
                     "04.2" (aoc.day04/part2 (read-input input-file))
                     "05.1" (aoc.day05/part1 (read-input input-file))
                     "05.2" (aoc.day05/part2 (read-input input-file)))]
        (println result)
        result))))

