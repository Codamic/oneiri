(ns oneiri.home.subs
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :lang
 (fn [db]
   (:lang db)))
