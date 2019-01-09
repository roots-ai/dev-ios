package ai.roots;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import com.github.godness84.RNSparkButton.RNSparkButtonPackage;
import cl.json.RNSharePackage;
import com.surajit.rnrg.RNRadialGradientPackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.reactlibrary.RNInternetReachabilityPackage;
import com.rnfs.RNFSPackage;
import io.invertase.firebase.RNFirebasePackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.rt2zz.reactnativecontacts.ReactNativeContacts;
import com.showlocationservicesdialogbox.LocationServicesDialogBoxPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.transistorsoft.rnbackgroundfetch.RNBackgroundFetchPackage;
import com.wix.interactable.Interactable;
import com.dieam.reactnativepushnotification.ReactNativePushNotificationPackage;
import io.realm.react.RealmReactPackage;
import com.jamesisaac.rnbackgroundtask.BackgroundTaskPackage;

import cl.json.ShareApplication;

import com.RNFetchBlob.RNFetchBlobPackage;
//MAPS REMOVED
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
// import com.evollu.react.fa.FIRAnalyticsPackage;
import io.invertase.firebase.firestore.RNFirebaseFirestorePackage;
// import com.projectseptember.RNGL.RNGLPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ShareApplication, ReactApplication {

	private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
		@Override
		public boolean getUseDeveloperSupport() {
			return BuildConfig.DEBUG;
		}

		@Override
		protected List<ReactPackage> getPackages() {
			return Arrays.<ReactPackage>asList(
				new MainReactPackage(),
                new RNViewShotPackage(),
                new SplashScreenReactPackage(),
                new RNSparkButtonPackage(),
                new RNSharePackage(),
                new RNRadialGradientPackage(),
                new MapsPackage(),
                new LinearGradientPackage(),
                new RNInternetReachabilityPackage(),
                new RNFSPackage(),
                new RNFirebasePackage(),
                new RNDeviceInfo(),
                new ReactNativeContacts(),
                new LocationServicesDialogBoxPackage(),
                new VectorIconsPackage(),
                new RNBackgroundFetchPackage(),
            	new Interactable(),
            	new ReactNativePushNotificationPackage(),
            	new RealmReactPackage(),
            	new BackgroundTaskPackage(),
            	new RNFetchBlobPackage(),
    			// new FIRAnalyticsPackage(),
                new RNFirebaseFirestorePackage()
			);
		}
	};

	@Override
    public String getFileProviderAuthority() {
        return "ai.roots.provider";
    }

	@Override
	public ReactNativeHost getReactNativeHost() {
		return mReactNativeHost;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		BackgroundTaskPackage.useContext(this);
		SoLoader.init(this, /* native exopackage */ false);
	}
}
