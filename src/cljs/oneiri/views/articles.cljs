(ns oneiri.views.articles
  (:require [re-frame.core        :as re-frame]
            [oneiri.logger        :as logger]
            [oneiri.views.grommet :refer [title heading anchor glist list-item icon box paragraph
                                          timestamp value image]]
            [reagent.core         :as r]
            [hellhound.core       :refer [dispatch->server]]))



(defn ask-for-more
  [range]
  (let [new-range (map #(+ % 10) @range)]
    (dispatch->server [:fetch-articles new-range])
    (swap! range (fn [_] new-range))))

(defn select-article
  [article]
  (re-frame/dispatch [:select-article article]))


(defn article-details
  [article]
  [box
       [paragraph {:size "large"} (:description article)]

       [box {:direction "row"}

        (if-not (nil? (:publishedAt article))
          [box {:direction "row"}
           [icon "Clock" {:type "status"}]
           [box {:margin {:left "small"}}
            [timestamp {:value (:publishedAt article)}]]])

        (if-not (nil? (:category (:source article)))
          [box {:direction "row" :margin {:left "small"}}
           [icon "Catalog"]
           [box {:margin {:left "small"}}
            [:span (clojure.string/capitalize (:category (:source article)))]]])

        (if-not (nil? (:author article))
          [box {:direction "row" :margin {:left "small"}}
           [icon "User"]
           [box {:margin {:left "small"}}
            [:span (:author article)]]])

        [box {:direction "row" :margin {:left "small"}}
         [icon "Tag"]
         [box {:margin {:left "small"}}
          [value {:value "#something" :size "small"}]]]


        [box {:direction "row" :margin {:left "small"}}
         [anchor {:href  (:url article)
                  :icon  (icon "LinkNext")
                  :label "More"
                  :target "_blank"
                  :primary true}]]]])

(defn render-article
  "Render a single article"
  [article]
  (let [selected-id (re-frame/subscribe [:selected-article])]
    [list-item {:justify "between" :on-click #(js/alert "zxc")} ^{:key (:id article)}
     [box {:alignSelf "stretch" :direction "row"
           :align "center" :wrap true}

      [image {:src (:urlToImage article)  :size "small" :alt (:title article)}]

      [title {:truncate true}
       (:title article)]]

     [box {:direction "row"}
      (if (= @selected-id (:id article))
        [icon "Checkmark"])
      [anchor {:icon (icon "Like")}]]]))


(defn articles-list
  "This view is responsible for rendering a list of articles."
  []
  (let [articles (re-frame/subscribe [:recent-articles])
        range    (atom [0 10])]
      [box {:size :full :alignSelf :stretch}
       (if (empty? @articles)
         ;; If articles was empty
         [box {:size      :full
               :alignSelf :stretch
               :pad       "large"
               :align :center}

          [title "Fetching stories..."]]
         ;; If articles was not empty
         [glist {:selectable false
                 :onSelect   select-article
                 :onMore     #(ask-for-more range)}

          (for [article @articles]
            ^{:key (:id article)} [render-article article])])]))
