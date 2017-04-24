(ns oneiri.logger
  "Logger namespace which provides several wrapped functions around console
  object"
  (:require [goog.string  :as gstring]
            goog.string.format))


(defn debug
  [& rest]
  (js/console.debug (apply gstring/format rest)))

(defn info
  [& rest]
  (js/console.info (apply gstring/format rest)))

(defn warn
  [& rest]
  (js/console.warn (apply gstring/format rest)))

(defn error
  [& rest]
  (js/console.error (apply gstring/format rest)))
