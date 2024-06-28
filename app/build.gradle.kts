plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("dagger.hilt.android.plugin")
	//id("kotlin-kapt") //
	kotlin("kapt")
	id("kotlin-parcelize")
	id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
	namespace = "home.pokeman"
	compileSdk = 34
	defaultConfig {
		applicationId = "home.pokeman"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
//		Properties properties = new Properties()
//		if (rootProject.file("local.properties").exists()) {
//			properties.load(
//				rootProject
//					.file("local.properties")
//					.newDataInputStream()
//			)
//		}
		
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
		debug {
			buildConfigField(
				"String",
				"MAPS_API_KEY",
				"AIzaSyDpPgYVzbCOzaMUHFcnNwICgk70d4-1yE4"// properties.getProperty("MAPS_API_KEY")
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_18
		targetCompatibility = JavaVersion.VERSION_18
	}
	kotlinOptions {
		jvmTarget = "18"
	}
	buildFeatures {
		compose = true
		buildConfig = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.10"
	}
	hilt {
		enableAggregatingTask = false
	}
	secrets {
		// Optionally specify a different file name containing your secrets.
		// The plugin defaults to "local.properties"
		propertiesFileName = "secrets.properties"
		
		// A properties file containing default secret values. This file can be
		// checked in version control.
//		defaultPropertiesFileName = "local.defaults.properties"
		
		// Configure which keys should be ignored by the plugin by providing regular expressions.
		// "sdk.dir" is ignored by default.
		ignoreList.add("keyToIgnore") // Ignore the key "keyToIgnore"
		ignoreList.add("sdk.*")       // Ignore all keys matching the regexp "sdk.*"
	}
}

dependencies {
	utilitiesModule()
	authenticationModule()
	onboardingModule()
	
	defaultImports()
	splashScreen()
	coil()
	retrofit()
	compose()
	hilt()
	coroutines()
	
	//Lifecycle
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
	implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

	//Google Services & Maps
	implementation("com.google.android.gms:play-services-location:21.1.0")
	implementation("com.google.android.gms:play-services-maps:18.2.0")
	implementation("com.google.maps.android:maps-compose:2.9.0")
	implementation("com.google.android.libraries.places:places:3.0.0")
	
	//Accompanist (Permission)
	implementation("com.google.accompanist:accompanist-permissions:0.31.3-beta")
}

kapt {
	correctErrorTypes = true
}

//	packaging {
//		resources {
//			excludes += "/META-INF/{AL2.0,LGPL2.1}"
//		}
//		resources.excludes.addAll(
//			listOf(
//				"META-INF/LICENSE.md",
//				"META-INF/LICENSE-notice.md",
//				"/META-INF/{AL2.0,LGPL2.1}",
//				"META-INF/gradle/incremental.annotation.processors",
//			),
//		)
//	}
//    configurations {
//        implementation.configure { exclude(group = "org.jetbrains", module = "annotations") }
//    }