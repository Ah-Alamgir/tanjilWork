package com.tanjil.mywork.Remote

class jsonParser {
    companion object{
        val json: String
            get() = """
                
            {
  "বিভাগ": [
    {
      "চট্টগ্রাম": [
        {
          "কুমিল্লা": [
            "দেবিদ্বার",
            "বরুড়া",
            "ব্রাহ্মণপাড়া",
            "চান্দিনা",
            "চৌদ্দগ্রাম",
            "দাউদকান্দি",
            "হোমনা",
            "লাকসাম",
            "মুরাদনগর",
            "নাঙ্গলকোট",
            "কুমিল্লা সদর",
            "মেঘনা",
            "মনোহরগঞ্জ",
            "সদর দক্ষিণ",
            "তিতাস",
            "বুড়িচং",
            "লালমাই"
          ]
        },
        {
          "ফেনী": [
            "ছাগলনাইয়া উপজেলা",
            "ফেনী সদর",
            "সোনাগাজী উপজেলা",
            "ফুলগাজী উপজেলা",
            "পরশুরাম",
            "দাগনভূঞা"
          ]
        },
        {
          "ব্রাহ্মণবাড়িয়া": [
            "ব্রাহ্মণবাড়িয়া সদর",
            "কসবা",
            "নাসিরনগর",
            "সরাইল উপজেলা",
            "আশুগঞ্জ",
            "আখাউড়া",
            "নবীনগর",
            "বাঞ্ছারামপুর",
            "বিজয়নগর"
          ]
        },
        {
          "রাঙ্গামাটিা": [
            "রাঙ্গামাটি সদর",
            "কাপ্তাই",
            "কাউখালী",
            "বাঘাইছড়ি",
            "বরকল",
            "লংগদু",
            "রাজস্থলী",
            "বিলাইছড়ি",
            "জুরাছড়ি",
            "নানিয়ারচর"
          ]
        },
        {
          "নোয়াখালী ": [
            "নোয়াখালী",
            "কোম্পানীগঞ্জ",
            "বেগমগঞ্জ",
            "হাতিয়া",
            "সুবর্ণচর",
            "কবিরহাট",
            "সেনবাগ",
            "চাটখিল",
            "সোনাইমুড়ী"
          ]
        },
        {
          "চাঁদপুর": [
            "হাইমচর",
            "কচুয়া",
            "শাহরাস্তি",
            "চাঁদপুর সদর",
            "মতলব",
            "হাজীগঞ্জ",
            "মতলব",
            "ফরিদগঞ্জ"
          ]
        },
        {
          "লক্ষ্মীপুর": [
            "লক্ষ্মীপুর সদর",
            "কমলনগর ",
            "রায়পুর",
            "রামগতি",
            "রামগঞ্জ"
          ]
        },
        {
          "চট্টগ্রাম": [
            "রাঙ্গুনিয়া",
            "সীতাকুন্ড উপজেলা",
            "মীরসরাই",
            "পটিয়া",
            "সন্দ্বীপ",
            "বাঁশখালী",
            "বোয়ালখালী",
            "আনোয়ারা",
            "চন্দনাইশ",
            "সাতকানিয়া",
            "লোহাগাড়া",
            "হাটহাজারী",
            "ফটিকছড়ি",
            "রাউজান",
            "কর্ণফুলী"
          ]
        },
        {
          "বকক্সবাজার": [
            "কক্সবাজার সদর",
            "চকরিয়া",
            "কুতুবদিয়া",
            "উখিয়া",
            "মহেশখালী",
            "পেকুয়া",
            "রামু",
            "টেকনাফ"
          ]
        },
        {
          "খাগড়াছড়ি": [
            "খাগড়াছড়ি সদর",
            "দিঘীনালা",
            "পানছড়ি",
            "লক্ষীছড়ি",
            "মহালছড়ি",
            "মানিকছড়ি",
            "রামগড়",
            "মাটিরাঙ্গা",
            "গুইমারা"
          ]
        },
        {
          "বান্দরবান": [
            "বান্দরবান সদর",
            "আলীকদম",
            "নাইক্ষ্যংছড়ি",
            "রোয়াংছড়ি",
            "লামা",
            "রুমা",
            "থানচি"
          ]
        }
      ],
      "রাজশাহী": [
        {
          "সিরাজগঞ্জ": [
            "বেলকুচি",
            "চৌহালি",
            "কামারখন্দ",
            "কাজীপুর",
            "রায়গঞ্জ",
            "শাহজাদপুর",
            "সিরাজগঞ্জ",
            "তাড়াশ",
            "উল্লাপাড়া"
          ]
        },
        {
          "পাবনা": [
            "সুজানগর",
            "ঈশ্বরদী",
            "ভাঙ্গুড়া",
            "পাবনা সদর",
            "বেড়া",
            "আটঘরিয়া",
            "চাটমোহর",
            "সাঁথিয়া",
            "ফরিদপুর"
          ]
        },
        {
          "সবগুড়া": [
            "কাহালু উপজেলা",
            "বগুড়া সদর",
            "সারিয়াকান্দি",
            "শাজাহানপুর",
            "দুপচাচিঁয়া উপজেলা",
            "আদমদিঘি উপজেলা",
            "নন্দিগ্রাম",
            "সোনাতলা উপজেলা",
            "ধুনট উপজেলা",
            "গাবতলী",
            "শেরপুর উপজেলা",
            "শিবগঞ্জ"
          ]
        },
        {
          "সরাজশাহী": [
            "পবা উপজেলা",
            "দুর্গাপুর উপজেলা",
            "মোহনপুর উপজেলা",
            "চারঘাট উপজেলা",
            "পুঠিয়া উপজেলা",
            "বাঘা উপজেলা",
            "গোদাগাড়ী উপজেলা",
            "তানোর উপজেলা",
            "বাগমারা উপজেলা"
          ]
        },
        {
          "সিনাটোর": [
            "নাটোর সদর",
            "সিংড়া",
            "বড়াইগ্রাম",
            "বাগাতিপাড়া",
            "লালপুর",
            "গুরুদাসপুর",
            "নলডাঙ্গা"
          ]
        },
        {
          "জয়পুরহাট": [
            "আক্কেলপুর উপজেলা",
            "কালাই উপজেলা",
            "ক্ষেতলাল উপজেলা",
            "পাঁচবিবি উপজেলা",
            "জয়পুরহাট সদর"
          ]
        },
        {
          "চাঁপাইনবাবগঞ্জ": [
            "চাঁপাইনবাবগঞ্জ সদর",
            "গোমস্তাপুর",
            "নাচোল",
            "ভোলাহাট",
            "শিবগঞ্জ"
          ]
        },
        {
          "নওগাঁ": [
            "মহাদেবপুর উপজেলা",
            "বদলগাছী উপজেলা",
            "পত্নিতলা উপজেলা",
            "ধামইরহাট উপজেলা",
            "নিয়ামতপুর উপজেলা",
            "মান্দা উপজেলা",
            "আত্রাই উপজেলা",
            "রাণীনগর উপজেলা",
            "নওগাঁ সদর",
            "পোরশা উপজেলা",
            "সাপাহার"
          ]
        }
      ],
      "খুলনা": [
        {
          "যশোর": [
            "মণিরামপুর",
            "অভয়নগর",
            "বাঘারপাড়া",
            "চৌগাছা",
            "ঝিকরগাছা",
            "কেশবপুর",
            "যশোর সদর",
            "শার্শা"
          ]
        },
        {
          "সাতক্ষীরা": [
            "আশাশুনি",
            "দেবহাটা",
            "কলারোয়া",
            "সাতক্ষীরা সদর",
            "শ্যামনগর",
            "তালা",
            "কালিগঞ্জ"
          ]
        },
        {
          "মেহেরপুর": [
            "মুজিবনগর",
            "মেহেরপুর সদর",
            "গাংনী"
          ]
        },
        {
          "নড়াইল": [
            "নড়াইল সদর",
            "লোহাগড়া",
            "কালিয়া"
          ]
        },
        {
          "চুয়াডাঙ্গা": [
            "চুয়াডাঙ্গা সদর",
            "আলমডাঙ্গা",
            "দামুড়হুদা",
            "জীবননগর"
          ]
        },
        {
          "কুষ্টিয়া": [
            "কুষ্টিয়া সদর",
            "কুমারখালী",
            "খোকসা",
            "মিরপুর",
            "দৌলতপুর",
            "ভেড়ামারা"
          ]
        },
        {
          "মাগুরা": [
            "শালিখা",
            "শ্রীপুর",
            "মাগুরা সদর",
            "মহম্মদপুর"
          ]
        },
        {
          "খুলনা": [
            "পাইকগাছা",
            "ফুলতলা উপজেলা",
            "দিঘলিয়া উপজেলা",
            "রূপসা উপজেলা",
            "তেরখাদা উপজেলা",
            "ডুমুরিয়া উপজেলা",
            "বটিয়াঘাটা",
            "দাকোপ উপজেলা",
            "কয়রা উপজেলা"
          ]
        },
        {
          "বাগেরহাট": [
            "ফকিরহাট",
            "বাগেরহাট সদর",
            "মোল্লাহাট",
            "শরণখোলা",
            "রামপাল",
            "মোড়েলগঞ্জ",
            "কচুয়া",
            "মোংলা",
            "চিতলমারী"
          ]
        },
        {
          "ঝিনাইদহ": [
            "ঝিনাইদহ সদর",
            "শৈলকুপা",
            "হরিণাকুন্ডু",
            "কালীগঞ্জ",
            "কোটচাঁদপুর",
            "মহেশপুর"
          ]
        }
      ],
      "বরিশাল": [
        {"ঝালকাঠি": [
            "ঝালকাঠি সদর",
            "কাঠালিয়া",
            "নলছিটি",
            "রাজাপুর"
          ]
        },
        {
          "পটুয়াখালী": [
            "বাউফল",
            "পটুয়াখালী সদর",
            "দুমকি",
            "দশমিনা",
            "কলাপাড়া",
            "মির্জাগঞ্জ",
            "গলাচিপা",
            "রাঙ্গাবালী"
          ]
        },
        {
          "পিরোজপুর": [
            "পিরোজপুর সদর",
            "নাজিরপুর",
            "কাউখালী",
            "ভান্ডারিয়া",
            "মঠবাড়ীয়া",
            "নেছারাবাদ",
            "ইন্দুরকানী"
          ]
        },
        {
          "বরিশাল": [
            "বরিশাল সদর",
            "বাকেরগঞ্জ",
            "বাবুগঞ্জ",
            "উজিরপুর ",
            "বানারীপাড়া",
            "গৌরনদী",
            "আগৈলঝাড়া",
            "মেহেন্দিগঞ্জ",
            "মুলাদী ",
            "হিজলা"
          ]
        },
        {
          "ভোলা": [
            "ভোলা সদর",
            "বোরহান উদ্দিন",
            "চরফ্যাশন",
            "দৌলতখান",
            "মনপুরা",
            "তজুমদ্দিন",
            "লালমোহন"
          ]
        },
        {
          "বরগুনা": [
            "আমতলী",
            "বরগুনা সদর",
            "বেতাগী উপজেলা",
            "বামনা",
            "পাথরঘাটা",
            "তালতলি"
          ]
        }
      ],
      "সিলেট": [
        {
          "সিলেট": [
            "বালাগঞ্জ",
            "বিয়ানীবাজার",
            "বিশ্বনাথ",
            "কোম্পানীগঞ্জ",
            "ফেঞ্চুগঞ্জ",
            "গোলাপগঞ্জ",
            "গোয়াইনঘাট",
            "জৈন্তাপুর",
            "কানাইঘাট",
            "সিলেট সদর",
            "জকিগঞ্জ",
            "দক্ষিণ সুরমা",
            "ওসমানী"
          ]
        },
        {"মৌলভীবাজার": [
            "বড়লেখা",
            "কমলগঞ্জ",
            "কুলাউড়া",
            "মৌলভীবাজার সদর",
            "রাজনগর",
            "শ্রীমঙ্গল",
            "জুড়ী"
          ]
        },
        {"হবিগঞ্জ": [
            "নবীগঞ্জ",
            "বাহুবল",
            "আজমিরীগঞ্জ",
            "বানিয়াচং",
            "লাখাই",
            "চুনারুঘাট",
            "হবিগঞ্জ সদর",
            "মাধবপুর উপজেলা",
            "শায়েস্তাগঞ্জ"
          ]
        },
        {"সুনামগঞ্জ ": [
            "সুনামগঞ্জ সদর",
            "দক্ষিণ সুনামগঞ্জ",
            "বিশ্বম্ভরপুর",
            "ছাতক",
            "জগন্নাথপুর",
            "দোয়ারাবাজার",
            "তাহিরপুর",
            "ধর্মপাশা",
            "জামালগঞ্জ",
            "শাল্লা",
            "দিরাই",
            "মধ্যনগর"
          ]
        }
      ],"ঢাকা": [
        {"নরসিংদী": [
            "বেলাবো",
            "মনোহরদী",
            "নরসিংদী",
            "পলাশ",
            "রায়পুরা",
            "শিবপুর"
          ]
        },
        {"গাজীপুর": [
            "কালীগঞ্জ",
            "কালিয়াকৈর",
            "কাপাসিয়া",
            "গাজীপুর সদর",
            "শ্রীপুর"
          ]
        },
        {"শরীয়তপুর": [
            "শরিয়তপুর সদর",
            "নড়িয়া",
            "জাজিরা",
            "গোসাইরহাট",
            "ভেদরগঞ্জ",
            "ডামুড্যা"
          ]
        },
        {"নারায়ণগঞ্জ": [
            "আড়াইহাজার উপজেলা",
            "বন্দর উপজেলা",
            "নারায়নগঞ্জ সদর",
            "রূপগঞ্জ উপজেলা",
            "সোনারগাঁ উপজেলা"
          ]
        },
        {"টাঙ্গাইল": [
            "বাসাইল",
            "ভুয়াপুর",
            "দেলদুয়ার",
            "ঘাটাইল",
            "গোপালপুর",
            "মধুপুর",
            "মির্জাপুর",
            "নাগরপুর",
            "সখিপুর",
            "টাঙ্গাইল সদর",
            "কালিহাতী",
            "ধনবাড়ী"
          ]
        },
        {"কিশোরগঞ্জ": [
            "ইটনা",
            "কটিয়াদী",
            "ভৈরব",
            "তাড়াইল",
            "হোসেনপুর",
            "পাকুন্দিয়া",
            "কুলিয়ারচর",
            "কিশোরগঞ্জ সদর",
            "করিমগঞ্জ",
            "বাজিতপুর",
            "অষ্টগ্রাম",
            "মিঠামইন",
            "নিকলী"
          ]
        },
        {"মানিকগঞ্জ": [
            "হরিরামপুর",
            "সাটুরিয়া",
            "মানিকগঞ্জ সদর",
            "ঘিওর",
            "শিবালয়",
            "দৌলতপুর",
            "সিংগাইর"
          ]
        },
        {"ঢাকা": [
            "সাভার",
            "ধামরাই",
            "কেরাণীগঞ্জ",
            "নবাবগঞ্জ",
            "দোহার"
          ]
        },
        {"মুন্সিগঞ্জ": [
            "মুন্সিগঞ্জ সদর",
            "শ্রীনগর",
            "সিরাজদিখান",
            "লৌহজং",
            "গজারিয়া",
            "টংগীবাড়ি"
          ]
        },
        {"রাজবাড়ী": [
            "রাজবাড়ী সদর",
            "গোয়ালন্দ",
            "পাংশা",
            "বালিয়াকান্দি",
            "কালুখালী"
          ]
        },
        {"মাদারীপুর": [
            "মাদারীপুর সদর",
            "শিবচর",
            "কালকিনি",
            "রাজৈর",
            "ডাসার"
          ]
        },
        {"গোপালগঞ্জ": [
            "গোপালগঞ্জ সদর",
            "কাশিয়ানী",
            "টুংগীপাড়া",
            "কোটালীপাড়া",
            "মুকসুদপুর"
          ]
        },
        {"ফরিদপুর": [
            "ফরিদপুর সদর",
            "আলফাডাঙ্গা",
            "বোয়ালমারী",
            "সদরপুর",
            "নগরকান্দা",
            "ভাঙ্গা",
            "চরভদ্রাসন",
            "মধুখালী",
            "সালথা"
          ]
        }
      ],"রংপুর": [
        { "পঞ্চগড়": [
            "পঞ্চগড়",
            "দেবীগঞ্জ",
            "বোদা",
            "আটোয়ারী",
            "তেতুলিয়া"
          ]
        },
        {"দিনাজপুর":[
            "নবাবগঞ্জ",
            "বীরগঞ্জ উপজেলা",
            "ঘোড়াঘাট",
            "বিরামপুর",
            "পার্বতীপুর উপজেলা",
            "বোচাগঞ্জ উপজেলা",
            "কাহারোল উপজেলা",
            "ফুলবাড়ী উপজেলা",
            "দিনাজপুর সদর",
            "হাকিমপুর উপজেলা",
            "খানসামা",
            "বিরল উপজেলা",
            "চিরিরবন্দর উপজেলা"
          ]
        },
        {"লালমনিরহাট": [
            "লালমনিরহাট সদর",
            "কালীগঞ্জ",
            "হাতীবান্ধা",
            "পাটগ্রাম",
            "আদিতমারী উপজেলা"
          ]
        },
        {"নীলফামারী": [
            "সৈয়দপুর উপজেলা",
            "ডোমার উপজেলা",
            "ডিমলা",
            "জলঢাকা",
            "কিশোরগঞ্জ",
            "নীলফামারী সদর"
          ]
        },
        {"গাইবান্ধা": [
            "সাদুল্লাপুর",
            "গাইবান্ধা সদর",
            "পলাশবাড়ী",
            "সাঘাটা উপজেলা",
            "গোবিন্দগঞ্জ উপজেলা",
            "সুন্দরগঞ্জ",
            "ফুলছড়ি"
          ]
        },
        {"ঠাকুরগাঁও": [
            "ঠাকুরগাঁও সদর",
            "পীরগঞ্জ উপজেলা",
            "রাণীশংকৈল উপজেলা",
            "হরিপুর উপজেলা",
            "বালিয়াডাঙ্গী উপজেলা"
          ]
        },
        {"রংপুর": [
            "রংপুর সদর",
            "গংগাচড়া",
            "তারাগঞ্জ উপজেলা",
            "বদরগঞ্জ উপজেলা",
            "মিঠাপুকুর উপজেলা",
            "পীরগঞ্জ উপজেলা",
            "কাউনিয়া উপজেলা",
            "পীরগাছা উপজেলা"
          ]
        },
        {"কুড়িগ্রাম": [
            "কুড়িগ্রাম সদর",
            "নাগেশ্বরী",
            "ভুরুঙ্গামারী",
            "ফুলবাড়ী",
            "রাজারহাট",
            "উলিপুর",
            "চিলমারী",
            "রৌমারী",
            "চর রাজিবপুর"
          ]
        }
      ],"ময়মনসিংহ":[
        {"শেরপুর": [
            "শেরপুর সদর",
            "নালিতাবাড়ী উপজেলা",
            "শ্রীবরদী উপজেলা",
            "নকলা উপজেলা",
            "ঝিনাইগাতী উপজেলা"
          ]
        },
        {"ময়মনসিংহ": [
            "ফুলবাড়ীয়া",
            "ত্রিশাল",
            "ভালুকা",
            "মুক্তাগাছা",
            "ময়মনসিংহ সদর",
            "ধোবাউড়া",
            "ফুলপুর",
            "হালুয়াঘাট",
            "গৌরীপুর",
            "গফরগাঁও",
            "ঈশ্বরগঞ্জ",
            "নান্দাইল",
            "তারাকান্দা"
          ]
        },
        {"জামালপুর": [
            "জামালপুর সদর",
            "মেলান্দহ",
            "ইসলামপুর",
            "দেওয়ানগঞ্জ",
            "সরিষাবাড়ী",
            "মাদারগঞ্জ",
            "বকশীগঞ্জ"
          ]
        },
        {"নেত্রকোণা": [
            "বারহাট্টা",
            "দুর্গাপুর",
            "কেন্দুয়া",
            "আটপাড়া",
            "মদন",
            "খালিয়াজুরী",
            "কলমাকান্দা",
            "মোহনগঞ্জ",
            "পূর্বধলা",
            "নেত্রকোণা সদর"
          ]
        }
      ]
    }
  ]
}

""".trimIndent()
    }
}