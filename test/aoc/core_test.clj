(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]))

(deftest a-test
  (testing "Day 01 Part 1 example"
    (is (= 24000 (-main "01" "1" "example"))))
  (testing "Day 01 Part 2 example"
    (is (= 45000 (-main "01" "2" "example"))))
  (testing "Day 02 Part 1 example"
    (is (= 15 (-main "02" "1" "example"))))
  (testing "Day 02 Part 2 example"
    (is (= 12 (-main "02" "2" "example"))))
  (testing "Day 03 Part 1 example"
    (is (= 157 (-main "03" "1" "example"))))
  (testing "Day 03 Part 2 example"
    (is (= 70 (-main "03" "2" "example")))))
