<header id="banner" class="wrapper">
  <div class="inner">
    <h2 id="banner-title">{{ page.subtitle }}</h2>
    <div id="banner-start">
      <span id="banner-start-command">{{ __('index.getStart') }}</span><a id="banner-start-link" href="usage/"><i class="fa fa-arrow-right"></i></a>
    </div>
    {#
      <div id="banner-share">{{ partial('partial/share') }}</div>
    #}
  </div>
</header>
<div id="content-wrap">
  <div class="wrapper">
    <div class="inner">
      <ul id="intro-feature-list">
       <li class="intro-feature-wrap">
           <div class="intro-feature">
               <div class="intro-feature-icon">
                   <i class="fa fa-bolt"></i>
               </div>
               <h3 class="intro-feature-title">{{ __('index.feature1.title') }}</h3>
               <p class="intro-feature-desc">{{ __('index.feature1.description') }}</p>
           </div>
       </li>
       <li class="intro-feature-wrap">
           <div class="intro-feature">
               <div class="intro-feature-icon">
                   <i class="fa fa-pencil"></i>
               </div>
               <h3 class="intro-feature-title">{{ __('index.feature2.title') }}</h3>
                              <p class="intro-feature-desc">{{ __('index.feature2.description') }}</p>
           </div>
       </li>
       <li class="intro-feature-wrap">
           <div class="intro-feature">
               <div class="intro-feature-icon">
                   <i class="fa fa-cloud-upload"></i>
               </div>
               <h3 class="intro-feature-title">{{ __('index.feature3.title') }}</h3>
                              <p class="intro-feature-desc">{{ __('index.feature3.description') }}</p>
           </div>
       </li>
       <li class="intro-feature-wrap">
           <div class="intro-feature">
               <div class="intro-feature-icon">
                   <i class="fa fa-cog"></i>
               </div>
               <h3 class="intro-feature-title">{{ __('index.feature4.title') }}</h3>
                              <p class="intro-feature-desc">{{ __('index.feature4.description') }}</p>
           </div>
       </li>
   </ul>
      <ul id="intro-cmd-wrap">
        <li class="intro-cmd-item"></li>
      </ul>
      <div id="intro-get-started-wrap">
        <!--
        <a href="{{ index_link('/usage/') }}" id="intro-get-started-link">{{ __('index.getStart') }}</a>
        -->
        <a href="usage/" id="intro-get-started-link">{{ __('index.getStart') }}</a>
      </div>
    </div>
  </div>
</div>
