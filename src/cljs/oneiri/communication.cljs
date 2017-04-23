(ns oneiri.communication
  (:require-macros
   [cljs.core.async.macros :as asyncm :refer (go go-loop)])
  (:require
   [cljs.core.async :as async :refer (<! >! put! chan)]
   [taoensso.sente  :as sente :refer (cb-success?)]))


(defn setup
  "Setup the communication layer"
  []
  (let [{:keys [chsk ch-recv send-fn state]}
      (sente/make-channel-socket! "/chsk" ; Note the same path as before
       {:type :auto ; e/o #{:auto :ajax :ws}
       })]
    (def chsk       chsk)
    ;; ChannelSocket's receive channel
    (def ch-chsk    ch-recv)
    ;; ChannelSocket's send API fn
    (def chsk-send! send-fn)
    ;; Watchable, read-only atom
    (def chsk-state state)))
